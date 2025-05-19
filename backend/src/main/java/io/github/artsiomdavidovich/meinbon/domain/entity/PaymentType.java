package io.github.artsiomdavidovich.meinbon.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "payment_type")
@Schema(description = "Class that describes PaymentType.")
public class PaymentType {

    @Id
    @Schema(description = "PaymentType's unique identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "title", unique = true)
    @NotBlank
    @Schema(description = "PaymentType's title.", example = "Contactless")
    private String title;

    @OneToMany(mappedBy = "paymentType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Schema(description = "List of receipts with definite PaymentType.")
    private Set<Receipt> receipts = new HashSet<>();

    @Override
    public String toString() {
        return String.format("PaymentType: id - %d, title - %s", id, title);
    }

}
