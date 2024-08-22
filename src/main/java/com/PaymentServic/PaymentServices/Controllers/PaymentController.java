package com.PaymentServic.PaymentServices.Controllers;

import com.PaymentServic.PaymentServices.DTOS.InitiatePaymentRequestDTO;
import com.PaymentServic.PaymentServices.Services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO initiatePaymentRequestDTO){
        return paymentService.initiatePayment(initiatePaymentRequestDTO.getOrderId(),initiatePaymentRequestDTO.getEmail(),
                initiatePaymentRequestDTO.getMobilenumber(),initiatePaymentRequestDTO.getAmount());
    }
}
