package com.henripay.sepadd.dataaccess;

import com.henripay.sepadd.api.model.*;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

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

    List<CreditTransferRequestData> getReadyToProcessCreditTransferransactions(int batchSize);


}
