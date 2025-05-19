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
@Table(name = "category")
@Schema(description = "Class that describes Category.")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    @Schema(description = "Categories unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank
    @Column(name = "title", unique = true)
    @Schema(description = "Category's title.", example = "Grocery")
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Schema(description = "List of products with the corresponding Category.")
    private Set<ProductNormalized> products = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Category: id - %d, title - %s", id, title);
    }

}
