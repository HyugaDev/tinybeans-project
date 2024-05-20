package com.tinybeans.backend.evaluation.controller;

import com.tinybeans.backend.evaluation.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller for handling payment-related operations.
 *
 * @version 1.0
 * @since 2024-05-20
 * @author Anna Mack
 */
@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/transaction")
public class PaymentController {
    private final ITransactionService transactionService;

    /**
     * Creates a payment intent for a specified amount.
     *
     * @param amount the amount for the payment intent
     * @return a ResponseEntity containing the payment intent details
     */
    @PostMapping("/stripe/{amount}") @CrossOrigin(origins = "*")
    public ResponseEntity<?> getIntent(@PathVariable Long amount) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.makeCardTransaction(amount));
    }
}
