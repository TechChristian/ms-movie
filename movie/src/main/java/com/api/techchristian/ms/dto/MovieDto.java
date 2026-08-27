package com.api.techchristian.ms.dto;

import com.api.techchristian.ms.database.enums.GenreEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class MovieDto {
    public record create(
            @NotBlank(message = "the field title is required.")
            String title,

            @NotBlank(message = "the field description is required.")
            String description,

            @NotNull(message = "the field genre is required.")
            GenreEnum genre,

            @NotNull(message = "session time is necessary.")
            LocalDateTime sessionTime,

            @NotNull(message = "price is required.")
            BigDecimal price,

            @NotNull(message = "the field release year is required.")
            int releaseYear
    ){}
    public record response(
            UUID movieId,
            String title,
            String description,
            GenreEnum genre,
            LocalDateTime sessionTime,
            BigDecimal price,
            int releaseYear
    ){}
}
