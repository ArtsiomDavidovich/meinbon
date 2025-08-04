package io.github.artsiomdavidovich.meinbon.repository;

import io.github.artsiomdavidovich.meinbon.domain.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

    Optional<PaymentType> findPaymentTypeByTitle(String title);

}
