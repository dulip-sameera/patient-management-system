package dev.dulipsameera.authservice.service;

import dev.dulipsameera.authservice.dto.LoginRequestDTO;

import java.util.Optional;

public interface AuthService {

    Optional<String> authenticate(LoginRequestDTO loginRequestDTO);
    boolean validateToken(String token);
}
