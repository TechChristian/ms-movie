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
@Table(name = "DB_TICKET",
    uniqueConstraints = {
        @UniqueConstraint(
                name = "session_seat",
                columnNames = {"movie_id", "seat"}
        )
})
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticketId;
    @Column(nullable = false)
    private UUID userId;
    @Column(name = "movie_id", nullable = false)
    private UUID movieId;
    @Column(nullable = false)
    private int seat;
    @Column(nullable = false)
    private TicketStatus status;
}
