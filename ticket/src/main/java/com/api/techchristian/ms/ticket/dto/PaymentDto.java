package com.api.techchristian.ms.ticket.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class PaymentDto{
    UUID ticketId;
    UUID userId;
    UUID movieId;
    BigDecimal price;
}
