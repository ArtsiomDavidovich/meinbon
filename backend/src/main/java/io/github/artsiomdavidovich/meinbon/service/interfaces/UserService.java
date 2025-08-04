package io.github.artsiomdavidovich.meinbon.service.interfaces;

import io.github.artsiomdavidovich.meinbon.domain.entity.User;

import java.util.Optional;

public interface UserService {

    User getUserByEmail(String email);

    User getUserById(Long id);

}
