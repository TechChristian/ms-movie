package com.api.techchristian.ms.payment.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value(value = "${broker.queue.ticket.ticket-create}")
    private String ticketCreate;

    @Value(value = "${broker.queue.ticket.ticket-payment}")
    private String ticketPayment;

    @Bean
    public Queue ticketCreateQueue() {
        return new Queue(ticketCreate, true);
    }

    @Bean
    public Queue ticketPaymentQueue() {
        return new Queue(ticketPayment, true);
    }

    // * convert messages (objects) in JSON.
    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }
}
