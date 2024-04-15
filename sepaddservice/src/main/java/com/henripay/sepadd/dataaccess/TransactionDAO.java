package com.henripay.sepadd.dataaccess;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.dto.CreditTransferRequest;
import com.henripay.sepadd.dto.CreditTransferRequestData;
import com.henripay.sepadd.dto.DirectDebitRequestData;
import com.henripay.sepadd.dto.TransactionStatusResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface TransactionDAO {
    static final String DD_COLLECTION = "direct_debit_collection";
    static final String CT_COLLECTION = "credit_transfer_collection";

    String addTransaction(String id, String type, Map<String, Object> data) throws JacksonUtilityException, FirebaseException, IOException;
    //  String addCreditTransferTransaction(String id , Map<String, Object> data) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException;


    CreditTransferRequest[] queryCTTranasctions(int MaxNumber, String queryString);

    TransactionStatusResponse queryTransactionStatusByTransactionId(String transactionId, String type);

    CreditTransferRequest queryCTTransactionByTransactionId(String transactionId);

    TransactionStatusResponse deleteTransaction(String transactionId, String type);

    List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize);

    List<CreditTransferRequestData> getReadyToProcessCreditTransferransactions(int batchSize);


}
