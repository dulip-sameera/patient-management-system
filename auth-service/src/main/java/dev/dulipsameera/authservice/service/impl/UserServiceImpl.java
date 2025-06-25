package dev.dulipsameera.authservice.service.impl;

import dev.dulipsameera.authservice.model.User;
import dev.dulipsameera.authservice.repository.UserRepository;
import dev.dulipsameera.authservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
