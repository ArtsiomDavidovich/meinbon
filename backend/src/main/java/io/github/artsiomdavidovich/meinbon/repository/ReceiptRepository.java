package io.github.artsiomdavidovich.meinbon.repository;

import io.github.artsiomdavidovich.meinbon.domain.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    Optional<Receipt> findReceiptByIdAndUserId(Long id, Long userId);

}
