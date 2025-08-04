package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.entity.ProductNormalized;
import io.github.artsiomdavidovich.meinbon.domain.entity.ProductRaw;
import io.github.artsiomdavidovich.meinbon.domain.entity.User;

public interface ProductNormalizedService {

    ProductNormalized getOrCreateByProductRawOrUser(ProductRaw productRaw, User user);

}
