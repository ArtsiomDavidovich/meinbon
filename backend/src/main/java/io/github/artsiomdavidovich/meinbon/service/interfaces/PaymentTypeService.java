package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.entity.PaymentType;

public interface PaymentTypeService {

    PaymentType getPaymentTypeByTitle(String title);

}
