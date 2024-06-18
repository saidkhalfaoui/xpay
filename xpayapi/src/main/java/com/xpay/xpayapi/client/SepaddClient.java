package com.xpay.xpayapi.client;

import com.xpay.xpayapi.dto.CreditTransferRequest;
import com.xpay.xpayapi.dto.DirectDebitRequest;
import com.xpay.xpayapi.dto.TransactionResponse;
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
