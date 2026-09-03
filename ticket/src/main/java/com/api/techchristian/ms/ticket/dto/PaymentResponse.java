package com.api.techchristian.ms.ticket.dto;

import com.api.techchristian.ms.ticket.database.enums.TicketStatus;

import java.util.UUID;

public record PaymentResponse(
        UUID ticketId,
        TicketStatus status
) {}