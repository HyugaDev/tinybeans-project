package com.tinybeans.backend.evaluation.service;

import org.springframework.http.ResponseEntity;

public interface ITransactionService {
    ResponseEntity<?> makeCardTransaction(Long amount);
}
