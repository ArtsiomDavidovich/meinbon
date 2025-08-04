package io.github.artsiomdavidovich.meinbon.domain.dto.receipt_dto.response_dto;

import io.github.artsiomdavidovich.meinbon.domain.dto.product_raw_dto.ProductRawDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Schema(description = "A class that defines the Receipt DTO for responses.")
public class ReceiptResponseDto {

    @NotNull(message = "Receipt's id can't be null.")
    @Schema(description = "Id of receipt where ProductRaws with undefined ProductNormalized were first met.")
    private Long receiptId;

    @NotNull(message = "User's id can't be empty.")
    @Schema(description = "Id of User who completed the purchase.")
    private Long userId;

    @NotNull(message = "List of goods can't be empty.")
    @Schema(description = "List of goods that need a title for their ProductNormalized field.")
    private List<ProductRawDto> productRawDtos;

}
