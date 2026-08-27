package com.api.techchristian.ms.ticket.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record MovieResponse(
        UUID movieId,
        String title,
        String description,
        LocalDateTime sessionTime,
        BigDecimal price,
        int releaseYear
) {}
