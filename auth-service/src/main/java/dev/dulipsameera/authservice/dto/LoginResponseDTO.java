package dev.dulipsameera.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LoginResponseDTO {

    @Getter
    private final String token;

}