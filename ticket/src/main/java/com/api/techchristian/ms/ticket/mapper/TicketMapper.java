package com.api.techchristian.ms.ticket.mapper;

import com.api.techchristian.ms.ticket.database.model.TicketEntity;
import com.api.techchristian.ms.ticket.dto.TicketDto;

public class TicketMapper {
    public static TicketEntity toEntity(TicketDto.Create createTicketDto) {
        return TicketEntity.builder()
                .userId(createTicketDto.userId())
                .movieId(createTicketDto.movieId())
                .seat(createTicketDto.seat())
                .build();

    }

    public static TicketDto.Response toResponse(TicketEntity ticketEntity){
        return new TicketDto.Response(
                ticketEntity.getUserId(),
                ticketEntity.getMovieId(),
                ticketEntity.getSeat(),
                ticketEntity.getPrice(),
                ticketEntity.getStatus()
        );
    }
}
