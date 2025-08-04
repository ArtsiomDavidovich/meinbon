package io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.request_dto;

import io.github.artsiomdavidovich.meinbon.domain.dto.product_raw_dto.ProductRawDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Schema(description = "A class that defines the Receipt request DTO with info for new Receipt creation.")
public class ReceiptNewRequestDto {

    @NotBlank(message = "Shop name can't be empty.")
    @Schema(description = "Name of the Shop where the receipt was created.")
    private String shopName;

    @NotBlank(message = "E-mail can't be empty.")
    @Schema(description = "E-mail of User who completed the purchase.")
    private String userEmail;

    @NotNull(message = "Date can't be empty.")
    @Schema(description = "Date and time when the receipt was printed.")
    private LocalDateTime date;

    @NotNull(message = "List of goods can't be empty.")
    @Schema(description = "List of goods that were bought.")
    private List<ProductRawDto> productRawDtos = new ArrayList<>();

    @NotBlank(message = "PaymentType can't be empty.")
    @Schema(description = "How the payment was commited.")
    private String paymentTypeTitle;

    @Override
    public String toString() {
        return String.format("ReceiptRequestDto: shopName - %s, userEmail - %s, date - %s, paymentTypeTitle - %s", shopName, userEmail, date, paymentTypeTitle);
    }

}
