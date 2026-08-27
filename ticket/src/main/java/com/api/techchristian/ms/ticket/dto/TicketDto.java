package com.api.techchristian.ms.ticket.dto;

import com.api.techchristian.ms.ticket.database.enums.TicketStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class TicketDto {
    public record Create(
            @NotNull(message = "user id is required.")
            UUID userId,
            @NotNull(message = "movie id is required.")
            UUID movieId,
            @Min(value = 1, message = "A seat between 1 and 30 is required.")
            @Max(value = 30, message ="A seat between 1 and 30 is required.")
            @NotNull(message = "seat is required.")
            int seat
    ) {
    }

    public record Response(
            UUID userId,
            UUID movieId,
            int seat,
            BigDecimal price,
            TicketStatus status
    ) {
    }
}
