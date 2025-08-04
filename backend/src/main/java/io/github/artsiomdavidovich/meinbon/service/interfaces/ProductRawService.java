package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.entity.ProductRaw;
import io.github.artsiomdavidovich.meinbon.domain.entity.User;

public interface ProductRawService {

    ProductRaw getOrCreateProductRawByTitle(String productRawTitle, User user);

}
