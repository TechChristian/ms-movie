package com.api.techchristian.ms.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDto(
        UUID ticketId,
        UUID userId,
        UUID movieId,
        BigDecimal price
) {}
