package com.api.techchristian.ms.ticket.service;

import com.api.techchristian.ms.ticket.client.MovieClient;
import com.api.techchristian.ms.ticket.client.UserClient;
import com.api.techchristian.ms.ticket.database.enums.TicketStatus;
import com.api.techchristian.ms.ticket.database.model.TicketEntity;
import com.api.techchristian.ms.ticket.database.repository.TicketRepository;
import com.api.techchristian.ms.ticket.dto.PaymentResponse;
import com.api.techchristian.ms.ticket.dto.TicketDto;
import com.api.techchristian.ms.ticket.mapper.TicketMapper;
import com.api.techchristian.ms.ticket.producer.TicketProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final MovieClient movieClient;
    private final UserClient userClient;
    private final TicketProducer ticketProducer;

    @Transactional
    public TicketDto.Response addTicket(TicketDto.Create createTicket){
        log.info("Creating ticket - movieId: {}, userId: {}, seat: {}",
                createTicket.movieId(),
                createTicket.userId(),
                createTicket.seat());

        var movie = movieClient.getMovie(createTicket.movieId());

        var user = userClient.getUser(createTicket.userId());

        var ticket = TicketMapper.toEntity(createTicket);

        ticket.setMovieId(movie.movieId());
        ticket.setUserId(user.userId());
        ticket.setPrice(movie.price());
        ticket.setSeat(createTicket.seat());
        ticket.setStatus(TicketStatus.PENDING);

        var savedTicket = ticketRepository.save(ticket);

        log.info("Saved ticket: {}", savedTicket);

        ticketProducer.createPayment(savedTicket);

        return TicketMapper.toResponse(savedTicket);

    }

    @Transactional
    public void updateStatusTicket(PaymentResponse paymentResponse) {

        var ticket = ticketRepository.findById(paymentResponse.ticketId())
                .orElseThrow(() -> new RuntimeException("ticket not found."));

        ticket.setStatus(paymentResponse.status());

        ticketRepository.save(ticket);
    }
}
