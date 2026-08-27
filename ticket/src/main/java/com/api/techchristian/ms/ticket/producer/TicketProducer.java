package com.api.techchristian.ms.ticket.producer;

import com.api.techchristian.ms.ticket.database.model.TicketEntity;
import com.api.techchristian.ms.ticket.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.ticket.name}")
    private String ticketCreated;

    public void createPayment(TicketEntity ticketEntity) {
        PaymentDto paymentCreateDto = new PaymentDto();

        paymentCreateDto.setTicketId(ticketEntity.getTicketId());
        paymentCreateDto.setUserId(ticketEntity.getUserId());
        paymentCreateDto.setMovieId(ticketEntity.getMovieId());
        paymentCreateDto.setPrice(ticketEntity.getPrice());

        rabbitTemplate.convertAndSend("", ticketCreated, paymentCreateDto);
    }

}
