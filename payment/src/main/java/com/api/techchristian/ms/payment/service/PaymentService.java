package com.api.techchristian.ms.payment.service;

import com.api.techchristian.ms.payment.dto.PaymentDto;
import com.api.techchristian.ms.payment.dto.PaymentResponse;
import com.api.techchristian.ms.payment.enums.TicketStatus;
import com.api.techchristian.ms.payment.producer.PaymentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentProducer paymentProducer;

    public void sendPayment(PaymentDto paymentDto) {
           var price = paymentDto.price();
           TicketStatus ticketStatus;

           if(price.compareTo(BigDecimal.ONE) >= 0){
               ticketStatus = TicketStatus.PAID;
           }
           else{
                ticketStatus = TicketStatus.CANCELLED;
           }

           var paymentResponse = new PaymentResponse(
                   paymentDto.ticketId(),
                   ticketStatus
           );

           paymentProducer.sendPayment(paymentResponse);
    }
}
