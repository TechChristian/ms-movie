package com.api.techchristian.ms.ticket.database.repository;

import com.api.techchristian.ms.ticket.database.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {
}
