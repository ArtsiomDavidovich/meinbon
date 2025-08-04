package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.dto.product_raw_dto.ProductRawAndNormalizedDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.product_raw_dto.ProductRawDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto.ReceiptNewRequestDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto.ReceiptProdNormTitlesRequestDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.response_dto.ReceiptResponseDto;
import io.github.artsiomdavidovich.meinbon.domain.entity.*;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ReceiptNotFoundOrDoesntBelongToUserException;
import io.github.artsiomdavidovich.meinbon.repository.CategoryRepository;
import io.github.artsiomdavidovich.meinbon.repository.ReceiptRepository;
import io.github.artsiomdavidovich.meinbon.repository.ShopRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final CategoryService categoryService;
    private final ShopService shopService;
    private final UserService userService;
    private final PaymentTypeService paymentTypeService;
    private final ProductRawService productRawService;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ShopRepository shopRepository, CategoryRepository categoryRepository, CategoryService categoryService, ShopService shopService, UserService userService, PaymentTypeService paymentTypeService, ProductRawService productRawService) {
        this.receiptRepository = receiptRepository;
        this.categoryService = categoryService;
        this.shopService = shopService;
        this.userService = userService;
        this.paymentTypeService = paymentTypeService;
        this.productRawService = productRawService;
    }

    @Transactional
    @Override
    public ReceiptResponseDto addReceipt(ReceiptNewRequestDto receiptRequestDto) {

        User user = userService.getUserByEmail(receiptRequestDto.getUserEmail());

        Receipt newReceipt = new Receipt();

        newReceipt.setUser(user);
        newReceipt.setShop(shopService.getShopByName(receiptRequestDto.getShopName()));
        newReceipt.setDate(receiptRequestDto.getDate());
        newReceipt.setPaymentType(paymentTypeService.getPaymentTypeByTitle(receiptRequestDto.getPaymentTypeTitle()));

        ReceiptResponseDto receiptResponseDto = new ReceiptResponseDto();
        receiptResponseDto.setReceiptId(newReceipt.getId());
        receiptResponseDto.setUserId(user.getId());

        for (ProductRawDto rawDto : receiptRequestDto.getProductRawDtos()) {

            ProductRaw raw = productRawService.getOrCreateProductRawByTitle(rawDto.getProductRawTitle(), user);

            if (raw.getProductNormalized() != null) {

                ReceiptProduct receiptProduct = new ReceiptProduct();
                receiptProduct.setReceipt(newReceipt);
                receiptProduct.setPrice(rawDto.getPrice());
                receiptProduct.setQuantity(rawDto.getQuantity());
                receiptProduct.setTotalPrice(receiptProduct.countTotalPrice(receiptProduct.getQuantity(), receiptProduct.getPrice()));
                receiptProduct.setProductNormalized(raw.getProductNormalized());

                newReceipt.getReceiptProducts().add(receiptProduct);

            } else {

                ProductRawDto rawResponseDto = new ProductRawDto();
                rawResponseDto.setPrice(rawDto.getPrice());
                rawResponseDto.setQuantity(rawDto.getQuantity());
                rawResponseDto.setProductRawTitle(rawDto.getProductRawTitle());

                receiptResponseDto.getProductRawDtos().add(rawResponseDto);

            }
        }

        return receiptResponseDto;

    }

    @Transactional
    @Override
    public void complementReceipt(ReceiptProdNormTitlesRequestDto receiptRequestDto) {

        Receipt receipt = receiptRepository.findReceiptByIdAndUserId(receiptRequestDto.getReceiptId(), receiptRequestDto.getUserId()).
                orElseThrow(
                        () -> new ReceiptNotFoundOrDoesntBelongToUserException(receiptRequestDto.getReceiptId(), receiptRequestDto.getUserId())
                );

        for (ProductRawAndNormalizedDto rawDto : receiptRequestDto.getProductRawDtos()) {

            ProductNormalized productNormalized = new ProductNormalized();
            productNormalized.setCategory(categoryService.getCategoryByTitle(rawDto.getCategoryTitle()));
            productNormalized.setTitle(rawDto.getProductNormalizedTitle());
            productNormalized.setUser(userService.getUserById(receiptRequestDto.getUserId()));
            productNormalized.getProductRaws().add(productRawService.getOrCreateProductRawByTitle(rawDto.getProductRawTitle(), productNormalized.getUser()));

            ReceiptProduct receiptProduct = new ReceiptProduct();
            receiptProduct.setProductNormalized(productNormalized);
            receiptProduct.setReceipt(receipt);
            receiptProduct.setPrice(rawDto.getPrice());
            receiptProduct.setQuantity(rawDto.getQuantity());
            receiptProduct.setTotalPrice(receiptProduct.countTotalPrice(rawDto.getQuantity(), rawDto.getPrice()));

            receipt.getReceiptProducts().add(receiptProduct);

        }
    }
}
