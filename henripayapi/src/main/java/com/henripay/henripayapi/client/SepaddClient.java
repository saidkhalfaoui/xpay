package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.DirectDebitRequest;
import com.henripay.henripayapi.dto.TransactionResponse;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface SepaddClient {

    @PostExchange("/direct-debit")
    Mono<TransactionResponse> addDirectDebitTransaction(DirectDebitRequest request);
}
