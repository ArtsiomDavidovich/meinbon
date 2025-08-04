package io.github.artsiomdavidovich.meinbon.controller;

import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto.ReceiptNewRequestDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto.ReceiptProdNormTitlesRequestDto;
import io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.response_dto.ReceiptResponseDto;
import io.github.artsiomdavidovich.meinbon.service.interfaces.ReceiptService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    public final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @Operation(summary = "Add new receipt.",
            description = "Creates new receipt converting e-receipt into apps entity.")
    @PostMapping("/add")
    public ReceiptResponseDto createReceipt(
            @RequestBody ReceiptNewRequestDto receiptRequestDto
            ) {
        return receiptService.addReceipt(receiptRequestDto);
    }

    @Operation(summary = "Complements already existing receipt.",
            description = "Complements already existing receipt, adding new normalized Products named by User.")
    public void complementReceipt(
            @RequestBody ReceiptProdNormTitlesRequestDto receiptRequestDto
            ) {
        receiptService.complementReceipt(receiptRequestDto);
    }

}
