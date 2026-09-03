package com.api.techchristian.ms.payment.dto;

import com.api.techchristian.ms.payment.enums.TicketStatus;

import java.util.UUID;

public record PaymentResponse(
       UUID ticketId,
       TicketStatus status
) { }
