package io.github.artsiomdavidovich.meinbon.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "role")
@Schema(description = "Class that describes Users' roles in application.")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    @Schema(description = "Role's unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank
    @Column(name = "title", unique = true)
    @Schema(description = "Role's title.", example = "ROLE_USER")
    private String title;

    @Override
    public String toString() {
        return String.format("Role: id - %d, title - %s", id, title);
    }

}
