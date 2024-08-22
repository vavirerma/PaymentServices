package com.PaymentServic.PaymentServices.Services;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooser {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;
    public PaymentGatewayChooser(RazorpayPaymentGateway razorpayPaymentGateway,
                                 StripePaymentGateway stripePaymentGateway){
        this.razorpayPaymentGateway=razorpayPaymentGateway;
        this.stripePaymentGateway=stripePaymentGateway;
    }
    public PaymentGateway choose(){
        return stripePaymentGateway;
    }
}
