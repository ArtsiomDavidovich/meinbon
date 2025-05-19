package io.github.artsiomdavidovich.meinbon.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "product_raw")
@Schema(description = "Class that describes ProductRaw(products that come from e-receipts).")
public class ProductRaw {

    @Id
    @Setter(AccessLevel.NONE)
    @Schema(description = "ProductRaw's unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "title")
    @Schema(description = "ProductRaw's title(title of the product from e-receipt")
    private String title;

    @NotNull
    @JoinColumn(name = "product_normalized_id")
    @Schema(description = "ProductRaw's real title.")
    @ManyToOne
    private ProductNormalized productNormalized;

    @Override
    public String toString() {
        return String.format("ProductRaw: id - %d, title - %s, productNormalized - %s", id, title, productNormalized.getTitle());
    }

}
