package com.henripay.sepadd.service.impl;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.dataaccess.TransactionDAO;
import com.henripay.sepadd.dataaccess.model.CreditTransferJsonObjectMapper;
import com.henripay.sepadd.dataaccess.model.DirectDebitJsonObjectMapper;
import com.henripay.sepadd.dto.*;
import com.henripay.sepadd.service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    @Qualifier(value = "transactionDataJpaImpl")
    private TransactionDAO dao;

    private static final String DD_COLLECTION = "direct_debit_collection";
    private static final String CT_COLLECTION = "credit_transfer_collection";

    @Override
    public List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize) {
        return dao.getReadyToProcessDirectDebitTransactions(batchSize);
    }

    public List<CreditTransferRequestData> getReadyToProcessCreditTransferTransactions(int batchSize) {
        return dao.getReadyToProcessCreditTransferransactions(batchSize);
    }

    @Override
    public TransactionStatusResponse queryTransactionByTransactionId(String transactionId) {
        TransactionStatusResponse response = dao.queryTransactionStatusByTransactionId(transactionId, DD_COLLECTION);
        if (response.getStatus() != Statusenum.NOT_FOUND)
            return response;
        return dao.queryTransactionStatusByTransactionId(transactionId, CT_COLLECTION);

    }

    @Override
    public TransactionResponse addDirectDebitTransaction(DirectDebitRequest request) throws JacksonUtilityException, FirebaseException, IOException {
        DirectDebitRequestData directDebitRequestData = new DirectDebitRequestData();
        BeanUtils.copyProperties(request, directDebitRequestData);
        directDebitRequestData.setStatus(Statusenum.CREATED);
        directDebitRequestData.setProcessingStatus(Processingstatusenum.PENDING);
        directDebitRequestData.setCreationDate(LocalDateTime.now());
        directDebitRequestData.setLastUpdated(LocalDateTime.now());
        Map<String, Object> data = DirectDebitJsonObjectMapper.toHashMap(directDebitRequestData);
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        String transactionId = dao.addTransaction(id, DD_COLLECTION, data);

        return new TransactionResponse().transactionId(transactionId).status(Statusenum.CREATED).statusDescription("Created Successfully");
    }

    @Override
    public TransactionResponse addCreditTransferTransaction(CreditTransferRequest request) throws JacksonUtilityException, FirebaseException, IOException {
        CreditTransferRequestData creditTransferRequestData = new CreditTransferRequestData();
        BeanUtils.copyProperties(request, creditTransferRequestData);
        creditTransferRequestData.setStatus(Statusenum.CREATED);
        creditTransferRequestData.setProcessingStatus(Processingstatusenum.PENDING);
        creditTransferRequestData.setCreationDate(LocalDateTime.now());
        creditTransferRequestData.setLastUpdated(LocalDateTime.now());
        Map<String, Object> data = CreditTransferJsonObjectMapper.toHashMap(creditTransferRequestData);
        String id = UUID.randomUUID().toString().replaceAll("-", "");

        String transactionId = dao.addTransaction(id, CT_COLLECTION, data);

        return new TransactionResponse().transactionId(transactionId).status(Statusenum.CREATED).statusDescription("Created Successfully");


    }

    @Override
    public TransactionStatusResponse deleteTransaction(String transactionId) {

        TransactionStatusResponse response = dao.deleteTransaction(transactionId, DD_COLLECTION);
        if (response.getStatus() == Statusenum.NOT_FOUND) {
            return dao.deleteTransaction(transactionId, CT_COLLECTION);
        }

        return response;
    }


}


