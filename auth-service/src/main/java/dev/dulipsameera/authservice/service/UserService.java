package dev.dulipsameera.authservice.service;

import dev.dulipsameera.authservice.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);
}
