package com.api.techchristian.ms.payment.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDto(
        UUID ticketId,
        UUID userId,
        UUID movieId,
        BigDecimal price
) {}
