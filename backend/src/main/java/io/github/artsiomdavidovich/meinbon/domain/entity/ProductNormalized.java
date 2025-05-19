package io.github.artsiomdavidovich.meinbon.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "product_normalized")
@Schema(description = "Class that describes ProductNormalized(real products).")
public class ProductNormalized {

    @Id
    @Setter(AccessLevel.NONE)
    @Schema(description = "ProductNormalized unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Schema(description = "ProductNormalized title.")
    @Column(name = "title", unique = true)
    private String title;

    @NotNull
    @ManyToOne
    @Schema(description = "Product's category.")
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "productNormalized", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ProductRaw> productRaws = new HashSet<>();

    @OneToMany(mappedBy = "productNormalized", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<ReceiptProduct> productReceipts = new HashSet<>();

    @Override
    public String toString() {
        return String.format("ProductNormalized: id - %d, title - %s, category - %s", id, title, category.getTitle());
    }

}
