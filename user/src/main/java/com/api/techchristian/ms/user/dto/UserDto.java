package com.api.techchristian.ms.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    public record create(
            @NotBlank(message = "name is required.")
            String name,
            @Email(message = "invalid email format.")
            @NotBlank(message = "email is required.")
            String email
    ){}
    public record response(
            String name,
            String email
    ){}
}
