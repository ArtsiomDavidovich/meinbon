package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto.ReceiptNewRequestDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto.ReceiptProdNormTitlesRequestDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.response_dto.ReceiptResponseDto;

public interface ReceiptService {

    ReceiptResponseDto addReceipt(ReceiptNewRequestDto receiptRequestDto);

    void complementReceipt(ReceiptProdNormTitlesRequestDto receiptRequestDto);

}
