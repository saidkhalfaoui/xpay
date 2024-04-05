package com.henripay.sepadd.service.impl;

import com.henripay.common.exception.InvalidInput;
import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.domainservice.repository.TransactionRepository;
import com.henripay.sepadd.dto.*;
import com.henripay.sepadd.mapper.*;
import com.henripay.sepadd.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionStatusResponseMapper transactionStatusResponseMapper;
    private final DirectDebitRequestMapper directDebitRequestMapper;
    private final CreditTransferRequestMapper creditTransferRequestMapper;
    private final DirectDebitRequestDataMapper directDebitRequestDataMapper;
    private final CreditTransferRequestDataMapper creditTransferRequestDataMapper;
    private static final String DIRECT_DEBIT = "direct-debit";
    private static final String CREDIT_TRANSFER = "credit-transfer";

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionStatusResponseMapper transactionStatusResponseMapper, DirectDebitRequestMapper directDebitRequestMapper, CreditTransferRequestMapper creditTransferRequestMapper, DirectDebitRequestDataMapper directDebitRequestDataMapper, CreditTransferRequestDataMapper creditTransferRequestDataMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionStatusResponseMapper = transactionStatusResponseMapper;
        this.directDebitRequestMapper = directDebitRequestMapper;
        this.creditTransferRequestMapper = creditTransferRequestMapper;
        this.directDebitRequestDataMapper = directDebitRequestDataMapper;
        this.creditTransferRequestDataMapper = creditTransferRequestDataMapper;
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

    @Override
    public List<CreditTransferRequestData> getReadyToProcessCreditTransferTransactions(int batchSize) {
        List<TransactionEntity> transactionList = transactionRepository.findByNatureAndStatus(CREDIT_TRANSFER, String.valueOf(Statusenum.CREATED));
        if (transactionList != null) {
            transactionList = transactionList.subList(0, batchSize);
            return transactionList.stream().map(creditTransferRequestDataMapper::toDto).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize) {

        List<TransactionEntity> transactionList = transactionRepository.findByNatureAndStatus(DIRECT_DEBIT, String.valueOf(Statusenum.CREATED));
        if (transactionList != null) {
            transactionList = transactionList.subList(0, batchSize);
            return transactionList.stream().map(directDebitRequestDataMapper::toDto).collect(Collectors.toList());
        }
        return null;
    }


}


