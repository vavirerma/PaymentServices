package com.PaymentServic.PaymentServices.Services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayChooser paymentGatewayChooser;
    public PaymentService(PaymentGatewayChooser paymentGatewayChooser){
        this.paymentGatewayChooser=paymentGatewayChooser;
    }

    public String initiatePayment(String orderId, String email, String mobileNumber, Long amount){
        PaymentGateway paymentGateway=paymentGatewayChooser.choose();
        return paymentGateway.generatePaymentLink(orderId,email,mobileNumber,amount);
    }
}
