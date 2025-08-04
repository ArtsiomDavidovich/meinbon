package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.entity.ProductRaw;
import io.github.artsiomdavidovich.meinbon.domain.entity.User;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.repository.ProductRawRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.ProductRawService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductRawServiceImpl implements ProductRawService {

    private final ProductRawRepository productRawRepository;

    public ProductRawServiceImpl(ProductRawRepository productRawRepository) {
        this.productRawRepository = productRawRepository;
    }

    @Transactional
    @Override
    public ProductRaw getOrCreateProductRawByTitle(String productRawTitle, User user) {

        if (productRawRepository.existsByTitleAndUserId(productRawTitle, user.getId())) {

            return productRawRepository.findProductRawByTitleAndUserId(productRawTitle, user.getId())
                    .orElseThrow(
                            () -> new ObjectNotFoundException(String.format("ProductRaw with title: %s not found", productRawTitle))
                    );

        } else {

            ProductRaw raw = new ProductRaw();

            raw.setTitle(productRawTitle);
            raw.setUser(user);

            return raw;
        }
    }
}
