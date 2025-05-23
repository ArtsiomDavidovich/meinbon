package io.github.artsiomdavidovich.meinbon.repository;

import io.github.artsiomdavidovich.meinbon.domain.entity.ProductNormalized;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductNormalizedRepository extends JpaRepository<ProductNormalized, Long> {
}
