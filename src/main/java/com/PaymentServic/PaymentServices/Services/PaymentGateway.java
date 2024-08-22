package com.PaymentServic.PaymentServices.Services;

import org.springframework.stereotype.Service;

@Service
public interface PaymentGateway {
    String generatePaymentLink(String orderId,String email,String mobilenumber,Long amount);
}
