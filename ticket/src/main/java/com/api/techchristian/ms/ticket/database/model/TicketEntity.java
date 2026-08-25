package com.api.techchristian.ms.ticket.database.model;



import com.api.techchristian.ms.ticket.database.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DB_TICKET")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticketId;
    private UUID userId;
    private UUID movieId;
    @Column(nullable = false)
    private int seat;
    @Column(nullable = false)
    private TicketStatus status;
}
