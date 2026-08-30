package com.api.techchristian.ms.ticket.controller;

import com.api.techchristian.ms.ticket.dto.TicketDto;
import com.api.techchristian.ms.ticket.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/ticket")
@RequiredArgsConstructor
@Slf4j
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto.Response> addTicket (@RequestBody @Valid TicketDto.Create ticketDto) {
        TicketDto.Response response = ticketService.addTicket(ticketDto);
        log.info("Ticket added successfully {}", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
