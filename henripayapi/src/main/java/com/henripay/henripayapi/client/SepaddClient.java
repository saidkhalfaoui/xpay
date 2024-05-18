package com.henripay.henripayapi.client;

import com.henripay.henripayapi.dto.CreditTransferRequest;
import com.henripay.henripayapi.dto.DirectDebitRequest;
import com.henripay.henripayapi.dto.TransactionResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface SepaddClient {

    @PostExchange("/direct-debit")
    TransactionResponse addDirectDebitTransaction(@RequestBody DirectDebitRequest request);

    @DeleteExchange("/delete-transaction")
    TransactionResponse deleteTransaction(@RequestParam("transactionId") String transactionId);

    @PostExchange("/credit-transfer")
    TransactionResponse addCreditTransaction(@RequestBody CreditTransferRequest creditTransferRequest);
}
