package com.tinybeans.backend.evaluation.service.Impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.tinybeans.backend.evaluation.service.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class TransactionServiceImpl implements ITransactionService {

    @Value("${api.stripe.key}")
    private String key;

    @PostConstruct
    public void init() {
        Stripe.apiKey = key;
    }

    @Override
    public ResponseEntity<?> makeCardTransaction(Long amount) {
        try {
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(amount * 100L)
                            .setCurrency("usd")
                            .setAutomaticPaymentMethods(
                                    PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                            .setEnabled(true)
                                            .build())
                            .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return ResponseEntity.ok().body(paymentIntent.getClientSecret());
        } catch (StripeException e) {
            return ResponseEntity.badRequest().body("Transaction Error: " + e.getMessage());
        }
    }
}
