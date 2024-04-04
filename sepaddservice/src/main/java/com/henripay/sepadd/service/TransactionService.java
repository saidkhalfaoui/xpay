package com.henripay.sepadd.service;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.api.model.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TransactionService {

    TransactionStatusResponse queryTransactionByTransactionId(String transactionId);

    TransactionResponse addDirectDebitTransaction(DirectDebitRequest request) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;

    TransactionResponse addCreditTransferTransaction(CreditTransferRequest request) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;

    TransactionStatusResponse deleteTransaction(String transactionId);

    List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize);

    List<CreditTransferRequestData> getReadyToProcessCreditTransferTransactions(int batchSize);


}
