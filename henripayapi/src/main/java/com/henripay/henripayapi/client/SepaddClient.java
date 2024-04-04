package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.CreditTransferRequest;
import com.henripay.henripayapi.dto.DirectDebitRequest;
import com.henripay.henripayapi.dto.TransactionResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Mono;

public interface SepaddClient {

    @PostExchange("/direct-debit")
    Mono<TransactionResponse> addDirectDebitTransaction(@RequestBody DirectDebitRequest request);

    @DeleteExchange("/delete-transaction")
    Mono<TransactionResponse> deleteTransaction(@RequestParam("transactionId") String transactionId);

    @PostExchange("/credit-transfer")
    Mono<TransactionResponse> addCreditTransaction(@RequestBody CreditTransferRequest creditTransferRequest);
}
