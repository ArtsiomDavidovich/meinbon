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
@Table(name = "shop")
@Schema(description = "Class that describes Shop.")
public class Shop {

    @Id
    @Setter(AccessLevel.NONE)
    @Schema(description = "Shop's unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Schema(description = "Shop's name.", example = "Rewe")
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Receipt> receipts = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Shop: id - %d, name - %s", id, name);
    }
}
