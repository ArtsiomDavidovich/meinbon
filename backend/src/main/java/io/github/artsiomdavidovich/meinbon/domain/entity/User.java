package io.github.artsiomdavidovich.meinbon.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "\"user\"")
@Schema(description = "Class that describes Users.")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //Identity - for MySQL, Sequence - for PostgreSQL
    //@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1) - for custom sequences with custom allocation size. Default size 50.
    @Schema(description = "User's unique identifier.", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private Long id;

    @Email(message = "Invalid e-mail format.")
    @NotBlank(message = "E-mail can't be empty.")
    @Schema(description = "User's e-mail. Serves also as username.", example = "peter@gmail.com")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password can't be empty.")
    @Schema(description = "User's password.", accessMode = Schema.AccessMode.WRITE_ONLY) //WRITE_ONLY means the password can be sent to the server (e.g. during registration or login), but it won’t be shown in API responses (e.g. GET /users).
    @Column(name = "password", columnDefinition = "char(60)")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Schema(description = "List of User's roles.")
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of User's receipts.")
    private Set<Receipt> receipts = new HashSet<>();

    @Override
    public String toString() {
        return String.format("User: id - %d, email - %s, roles - %s", id, email, roles);
    }

}
