package com.PaymentServic.PaymentServices.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDTO {
    private String email;
    private String mobilenumber;
    private Long amount;
    private String orderId;
}
