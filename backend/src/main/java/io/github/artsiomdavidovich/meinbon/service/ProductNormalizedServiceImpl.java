package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.entity.ProductNormalized;
import io.github.artsiomdavidovich.meinbon.domain.entity.ProductRaw;
import io.github.artsiomdavidovich.meinbon.domain.entity.User;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.repository.ProductNormalizedRepository;
import io.github.artsiomdavidovich.meinbon.repository.ProductRawRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.ProductNormalizedService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductNormalizedServiceImpl implements ProductNormalizedService {

    private final ProductNormalizedRepository productNormalizedRepository;
    private final ProductRawRepository productRawRepository;

    public ProductNormalizedServiceImpl(ProductNormalizedRepository productNormalizedRepository, ProductRawRepository productRawRepository) {
        this.productNormalizedRepository = productNormalizedRepository;
        this.productRawRepository = productRawRepository;
    }

    @Transactional
    @Override
    public ProductNormalized getOrCreateByProductRawOrUser(ProductRaw productRaw, User user) {

            return productRawRepository.findProductRawByTitleAndUserId(productRaw.getTitle(), user.getId()).
                    orElseThrow(
                            () -> new ObjectNotFoundException(String.format("ProductRaw with title: %s not found", productRaw.getTitle()))
                    )
                    .getProductNormalized();
    }
}
