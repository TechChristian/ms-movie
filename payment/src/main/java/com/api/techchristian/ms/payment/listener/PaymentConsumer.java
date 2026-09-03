package com.api.techchristian.ms.payment.consumer;

import com.api.techchristian.ms.payment.dto.PaymentDto;
import com.api.techchristian.ms.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentConsumer {
    private final PaymentService paymentService;

    @RabbitListener(queues = "${broker.queue.ticket.ticket-create}")
    public void processPayment(@Payload PaymentDto paymentDto) {
        paymentService.sendPayment(paymentDto);
    }

}
