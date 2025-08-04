package io.github.artsiomdavidovich.meinbon.repository;

import io.github.artsiomdavidovich.meinbon.domain.entity.ProductNormalized;
import io.github.artsiomdavidovich.meinbon.domain.entity.ProductRaw;
import io.github.artsiomdavidovich.meinbon.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRawRepository extends JpaRepository<ProductRaw, Long> {

    boolean existsByTitleAndUserId(String title, Long userId );

    Optional<ProductRaw> findProductRawByTitleAndUserId(String title, Long userId);

}
