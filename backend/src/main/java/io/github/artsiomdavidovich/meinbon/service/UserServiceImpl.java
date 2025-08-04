package io.github.artsiomdavidovich.meinbon.service;

import io.github.artsiomdavidovich.meinbon.domain.entity.User;
import io.github.artsiomdavidovich.meinbon.exception_handling.custom_exceptions.ObjectNotFoundException;
import io.github.artsiomdavidovich.meinbon.repository.UserRepository;
import io.github.artsiomdavidovich.meinbon.service.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(
                () -> new ObjectNotFoundException(String.format("User with email: %s not found", email))
        );
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(String.format("User with id: %d not found", id))
        );
    }

}
