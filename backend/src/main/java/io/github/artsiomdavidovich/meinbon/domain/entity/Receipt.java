package io.github.artsiomdavidovich.meinbon.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "receipt")
@Schema(description = "Class that describes Receipt.")
public class Receipt {

    @Id
    @Setter(AccessLevel.NONE)
    @Schema(description = "Receipt's unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @JoinColumn(name = "shop_id")
    @ManyToOne
    @Schema(description = "Shop where the Receipt was received from.")
    private Shop shop;

    @NotNull
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @ManyToOne
    private User user;

    @NotNull
    @Schema(description = "Date of Receipt's creation.")
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Schema(description = "Receipt's total price.")
    @Digits(integer = 8, fraction = 2)
    @DecimalMin(value = "0.00")
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @NotNull
    @Schema(description = "Receipt's payment type.", example = "Contactless")
    @ManyToOne
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<ReceiptProduct> receiptProducts = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Receipt: id - %d, user - %s, shop - %s, date - %s, totalPrice - %.2f, paymentType - %s", id, user.getEmail(), shop.getName(), date, totalPrice, paymentType.getTitle());
    }
    
}
