package io.github.artsiomdavidovich.meinbon.domain.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReceiptProductId implements Serializable {

    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "product_normalized_id")
    private Long productNormalizedId;

}
