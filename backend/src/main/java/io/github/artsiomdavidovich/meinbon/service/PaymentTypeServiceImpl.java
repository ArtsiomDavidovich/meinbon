package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.entity.PaymentType;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.repository.PaymentTypeRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.PaymentTypeService;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public PaymentType getPaymentTypeByTitle(String title) {
        return paymentTypeRepository.findPaymentTypeByTitle(title).orElseThrow(
                () -> new ObjectNotFoundException(String.format("Payment type with title: %s not found", title))
        );
    }
}
