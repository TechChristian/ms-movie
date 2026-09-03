package com.api.techchristian.ms.payment.producer;

import com.api.techchristian.ms.payment.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.ticket.ticket-payment}")
    private String paymentQueue;

    public void sendPayment(PaymentResponse paymentResponse) {
        rabbitTemplate.convertAndSend(paymentQueue, paymentResponse);
    }

}
