package com.PaymentServic.PaymentServices.Services;

import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway{

    @Override
    public String generatePaymentLink(String orderId, String email, String mobilenumber, Long amount) {
        return null;
    }
}
