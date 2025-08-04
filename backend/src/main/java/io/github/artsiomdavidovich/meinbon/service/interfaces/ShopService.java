package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.entity.Shop;

public interface ShopService {

    Shop getShopByName(String shopName);

}
