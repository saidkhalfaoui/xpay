package com.henripay.sepadd.service.impl;

import com.henripay.sepadd.api.model.*;

import com.henripay.sepadd.dataaccess.TransactionDAO;

import com.henripay.sepadd.dataaccess.model.CreditTransferJsonObjectMapper;
import com.henripay.sepadd.dataaccess.model.DirectDebitJsonObjectMapper;
import com.henripay.sepadd.service.TransactionService;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDAO dao;
    private static final String DIRECT_DEBIT_PREFIX = "direct-debit";
    private static final String CREDIT_TRANSFER_PREFIX = "credit-transfer";

    private static final String DD_COLLECTION = "direct_debit_collection";
    private static final String CT_COLLECTION = "credit_transfer_collection";

    @Override
    public void loadConfigurations() {

    }

    @Override
    public List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize) {
        return dao.getReadyToProcessDirectDebitTransactions(batchSize);
    }

    public List<CreditTransferRequestData> getReadyToProcessCreditTransferTransactions(int batchSize) {
        return dao.getReadyToProcessCreditTransferransactions(batchSize);
    }


    @Override
    public void processDirectDebitTransaction() {

    }

    @Override
    public TransactionStatusResponse queryTransactionByTransactionId(String transactionId) {
        TransactionStatusResponse response = dao.queryTransactionStatusByTransactionId(transactionId, DD_COLLECTION);
        if (response.getStatus() != Statusenum.NOT_FOUND)
            return response;
        return dao.queryTransactionStatusByTransactionId(transactionId, CT_COLLECTION);

    }

    @Override
    public TransactionResponse addDirectDebitTransaction(DirectDebitRequest request) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {
        DirectDebitRequestData directDebitRequestData = new DirectDebitRequestData();
        BeanUtils.copyProperties(request, directDebitRequestData);
        directDebitRequestData.setStatus(Statusenum.CREATED);
        directDebitRequestData.setProcessingStatus(Processingstatusenum.PENDING);
        directDebitRequestData.setCreationDate(new Date());
        directDebitRequestData.setLastUpdated(new Date());
        Map<String, Object> data = DirectDebitJsonObjectMapper.toHashMap(directDebitRequestData);
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        String transactionId = dao.addTransaction(id, DD_COLLECTION, data);
        TransactionResponse response = new TransactionResponse().transactionId(transactionId).status(Statusenum.CREATED).statusDescription("Created Successfully");

        return response;
    }

    @Override
    public TransactionResponse addCreditTransferTransaction(CreditTransferRequest request) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {
        CreditTransferRequestData creditTransferRequestData = new CreditTransferRequestData();
        BeanUtils.copyProperties(request, creditTransferRequestData);
        creditTransferRequestData.setStatus(Statusenum.CREATED);
        creditTransferRequestData.setProcessingStatus(Processingstatusenum.PENDING);
        creditTransferRequestData.setCreationDate(new Date());
        creditTransferRequestData.setLastUpdated(new Date());
        Map<String, Object> data = CreditTransferJsonObjectMapper.toHashMap(creditTransferRequestData);
        String id = UUID.randomUUID().toString().replaceAll("-", "");

        String transactionId = dao.addTransaction(id, CT_COLLECTION, data);
        TransactionResponse response = new TransactionResponse().transactionId(transactionId).status(Statusenum.CREATED).statusDescription("Created Successfully");

        return response;


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

