package com.henripay.sepadd.dataaccess;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.api.model.CreditTransferRequest;
import com.henripay.sepadd.api.model.CreditTransferRequestData;
import com.henripay.sepadd.api.model.DirectDebitRequestData;
import com.henripay.sepadd.api.model.TransactionStatusResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface TransactionDAO {
    String addTransaction(String id, String type, Map<String, Object> data) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;
    //  String addCreditTransferTransaction(String id , Map<String, Object> data) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;


    CreditTransferRequest[] queryCTTranasctions(int MaxNumber, String queryString);

    TransactionStatusResponse queryTransactionStatusByTransactionId(String transactionId, String type);

    CreditTransferRequest queryCTTransactionByTransactionId(String transactionId);

    TransactionStatusResponse deleteTransaction(String transactionId, String type);

    List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize);

    List<CreditTransferRequestData> getReadyToProcessCreditTransferTransactions(int batchSize);


}
