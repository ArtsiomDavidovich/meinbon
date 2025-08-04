package io.github.artsiomdavidovich.meinbon.domain.dto.product_raw_dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Schema(description = "A class that defines the DTO with ProductRaw and ProductNormalized titles.")
public class ProductRawAndNormalizedDto {

    @NotBlank(message = "ProductRaw's title can't be empty.")
    @Schema(description = "How the Product is signed in the receipt.")
    private String productRawTitle;

    @NotBlank(message = "ProductNormalized's title can't be empty.")
    @Schema(description = "How the Product is signed in the receipt.")
    private String productNormalizedTitle;

    @NotBlank(message = "Category's title can't be empty.")
    @Schema(description = "Category of the Product.")
    private String categoryTitle;

    @NotNull(message = "Price can't be empty.")
    @Schema(description = "Price per one Product's item.")
    private BigDecimal price;

    @NotNull(message = "Quantity can't be empty.")
    @Schema(description = "Quantity of Product in the receipt.")
    private BigDecimal quantity;

    @Override
    public String toString() {
        return String.format("ProductRawRequestDto: productRawTitle - %s, productNormalizedTitle - %s, categoryTitle - %s, price - %.2f, quantity - %.3f", productRawTitle, productNormalizedTitle, categoryTitle, price, quantity);
    }

}
