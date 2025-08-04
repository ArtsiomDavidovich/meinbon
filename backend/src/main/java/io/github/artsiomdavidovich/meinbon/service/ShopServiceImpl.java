package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.entity.Shop;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.repository.ShopRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.ShopService;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Shop getShopByName(String shopName) {
        return shopRepository.findShopByName(shopName).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Shop with the name: %s not found", shopName))
        );
    }
}
