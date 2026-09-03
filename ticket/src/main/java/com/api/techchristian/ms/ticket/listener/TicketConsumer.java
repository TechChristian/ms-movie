package com.api.techchristian.ms.ticket.listener;

import com.api.techchristian.ms.ticket.dto.PaymentDto;
import com.api.techchristian.ms.ticket.dto.PaymentResponse;
import com.api.techchristian.ms.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketConsumer {
    private final TicketService ticketService;

    @RabbitListener(queues = "${broker.queue.ticket.ticket-payment}")
    public void processTicketPayment(@Payload PaymentResponse paymentResponse) {
        ticketService.updateStatusTicket(paymentResponse);
    }

}
