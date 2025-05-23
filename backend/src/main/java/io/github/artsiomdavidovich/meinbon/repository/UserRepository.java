package io.github.artsiomdavidovich.meinbon.repository;

import io.github.artsiomdavidovich.meinbon.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
