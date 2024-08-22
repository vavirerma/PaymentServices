package com.PaymentServic.PaymentServices.Services;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StripePaymentGateway implements PaymentGateway{
    @Value("${stripe.key.secret}")
    private String apiKey;

    @Override
    public String generatePaymentLink(String orderId, String email, String mobilenumber, Long amount) {
        // Set your secret key. Remember to switch to your live secret key in production.
// See your keys here: https://dashboard.stripe.com/apikeys
        Stripe.apiKey =apiKey;
        PriceCreateParams params =
                PriceCreateParams.builder()
                        .setCurrency("usd")
                        .setUnitAmount(amount)
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Earpiece").build()
                        )
                        .build();
        Price price=null;
        try{
            price=Price.create(params);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        PaymentLinkCreateParams param =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://github.com/vavirerma")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink=null;
        try{
            paymentLink=PaymentLink.create(param);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return paymentLink.getUrl().toString();
    }
}
