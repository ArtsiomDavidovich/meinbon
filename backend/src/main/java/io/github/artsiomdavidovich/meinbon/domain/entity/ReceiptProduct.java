package io.github.artsiomdavidovich.meinbon.domain.entity;

import io.github.artsiomdavidovich.meinbon.domain.compositeKey.ReceiptProductId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "receipt_product_normalized")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReceiptProduct {

    @EmbeddedId
    private ReceiptProductId id = new ReceiptProductId();

    @ManyToOne
    @MapsId("productNormalizedId")
    @JoinColumn(name = "product_normalized_id")
    private ProductNormalized productNormalized;

    @ManyToOne
    @MapsId("receiptId")
    @JoinColumn(name = "receipt_id")
    private Receipt receipt;

    @NotNull
    @Digits(integer = 4, fraction = 2)
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @Digits(integer = 3, fraction = 3)
    @Column(name = "quantity")
    private BigDecimal quantity;

    @Override
    public String toString() {
        return String.format("ReceiptProduct: receipt - %d, productNormalized - %s, price - %.2f, quantity - %.3f", receipt.getId(), productNormalized.getTitle(), price, quantity);
    }

}
