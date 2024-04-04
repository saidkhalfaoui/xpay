package com.henripay.sepadd.service.impl;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.domainservice.exception.InvalidInput;
import com.henripay.domainservice.repository.TransactionRepository;
import com.henripay.sepadd.api.model.*;
import com.henripay.sepadd.dataaccess.TransactionDAO;
import com.henripay.sepadd.mapper.CreditTransferRequestMapper;
import com.henripay.sepadd.mapper.DirectDebitRequestMapper;
import com.henripay.sepadd.mapper.TransactionStatusResponseMapper;
import com.henripay.sepadd.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionDAO dao;

    private final TransactionRepository transactionRepository;
    private final TransactionStatusResponseMapper transactionStatusResponseMapper;
    private final DirectDebitRequestMapper directDebitRequestMapper;
    private final CreditTransferRequestMapper creditTransferRequestMapper;
    private static final String DIRECT_DEBIT = "direct-debit";
    private static final String CREDIT_TRANSFER = "credit-transfer";

    private static final String DD_COLLECTION = "direct_debit_collection";
    private static final String CT_COLLECTION = "credit_transfer_collection";

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionStatusResponseMapper transactionStatusResponseMapper, DirectDebitRequestMapper directDebitRequestMapper, CreditTransferRequestMapper creditTransferRequestMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionStatusResponseMapper = transactionStatusResponseMapper;
        this.directDebitRequestMapper = directDebitRequestMapper;
        this.creditTransferRequestMapper = creditTransferRequestMapper;
    }

    @Override
    public List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize) {
        return dao.getReadyToProcessDirectDebitTransactions(batchSize);
    }

    public List<CreditTransferRequestData> getReadyToProcessCreditTransferTransactions(int batchSize) {
        return dao.getReadyToProcessCreditTransferransactions(batchSize);
    }


    @Override
    public TransactionStatusResponse queryTransactionByTransactionId(String transactionId) {
        Optional<TransactionEntity> transaction = transactionRepository.findByTransactionId(transactionId);
        return transactionStatusResponseMapper.toDto(transaction.orElseThrow(() -> new InvalidInput("Transaction not found")));
    }

    @Override
    public TransactionResponse addDirectDebitTransaction(DirectDebitRequest request) {
        return addTransaction(directDebitRequestMapper.toEntity(request), DIRECT_DEBIT);
    }

    @Override
    public TransactionResponse addCreditTransferTransaction(CreditTransferRequest request) {
        return addTransaction(creditTransferRequestMapper.toEntity(request), CREDIT_TRANSFER);
    }

    private TransactionResponse addTransaction(TransactionEntity entity, String transactionNature) {
        TransactionEntity transactionEntity;
        transactionEntity = entity;
        transactionEntity.setStatus(String.valueOf(Statusenum.CREATED));
        transactionEntity.setProcessingStatus(String.valueOf(Processingstatusenum.PENDING));
        transactionEntity.setCreationDate(LocalDate.now());
        transactionEntity.setLastUpdated(LocalDate.now());
        String transactionId = UUID.randomUUID().toString().replaceAll("-", "");
        transactionEntity.setTransactionId(transactionId);
        transactionEntity.setNature(transactionNature);
        transactionRepository.save(transactionEntity);
        return new TransactionResponse().transactionId(transactionId).status(Statusenum.CREATED).statusDescription("Created Successfully");
    }

    @Override
    public TransactionStatusResponse deleteTransaction(String transactionId) {
        Optional<TransactionEntity> transaction = transactionRepository.findByTransactionId(transactionId);
        if (transaction.isEmpty()) {
            throw new InvalidInput("Transaction not found");
        }
        transaction.get().setLastUpdated(LocalDate.now());
        transaction.get().setStatus(String.valueOf(Statusenum.DELETED));
        TransactionEntity transactionEntity = transactionRepository.save(transaction.get());
        return transactionStatusResponseMapper.toDto(transactionEntity);
    }


}


