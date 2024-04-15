package com.henripay.sepadd.dataaccess;


import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.domainservice.repository.TransactionRepository;
import com.henripay.sepadd.dto.*;
import com.henripay.sepadd.dto.mapper.TransactionDataJpaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class TransactionDataJpaImpl implements TransactionDAO {

    private final TransactionRepository transactionRepository;
    private final TransactionDataJpaMapper transactionDataJpaMapper;
    Logger logger = LoggerFactory.getLogger(TransactionDataJpaImpl.class);

    public TransactionDataJpaImpl(TransactionRepository transactionRepository, TransactionDataJpaMapper transactionDataJpaMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionDataJpaMapper = transactionDataJpaMapper;
    }

    @Override
    public String addTransaction(String id, String type, Map<String, Object> data) throws JacksonUtilityException, FirebaseException, UnsupportedEncodingException {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setStatus(data.get("status").toString().toUpperCase());
        transactionEntity.setProcessingStatus(Processingstatusenum.PENDING.toString());
        transactionEntity.setCreationDate((LocalDateTime) data.get("creationDate"));
        transactionEntity.setLastUpdated((LocalDateTime) data.get("lastUpdated"));
        transactionEntity.setTransactionId(id);
        transactionEntity.setNature(type);
        transactionRepository.save(transactionEntity);
        return id;

    }

    @Override
    public CreditTransferRequest[] queryCTTranasctions(int MaxNumber, String queryString) {
        return new CreditTransferRequest[0];
    }

    @Override
    public TransactionStatusResponse queryTransactionStatusByTransactionId(String transactionId, String type) {

        Optional<TransactionEntity> transaction = transactionRepository.findByTransactionIdAndNature(transactionId, type);
        TransactionStatusResponse transactionStatusResponse = new TransactionStatusResponse();
        transactionStatusResponse.setTransactionId(transactionId);
        if (transaction.isEmpty()) {
            transactionStatusResponse.setStatus(Statusenum.NOT_FOUND);
        } else {
            transactionStatusResponse.setStatus(Statusenum.valueOf(transaction.get().getStatus()));
            transactionStatusResponse.setProcessingStatus(Processingstatusenum.valueOf(transaction.get().getProcessingStatus()));
            transactionStatusResponse.setLastUpdated(transaction.get().getLastUpdated().toString());
        }
        return transactionStatusResponse;
    }


    @Override
    public CreditTransferRequest queryCTTransactionByTransactionId(String transactionId) {
        return null;
    }

    @Override
    public TransactionStatusResponse deleteTransaction(String transactionId, String type) {

        Optional<TransactionEntity> transaction = transactionRepository.findByTransactionIdAndNature(transactionId, type);
        LocalDateTime currentDate = LocalDateTime.now();
        TransactionStatusResponse transactionStatusResponse = new TransactionStatusResponse();
        if (transaction.isEmpty()) {
            transactionStatusResponse.setStatus(Statusenum.NOT_FOUND);
        } else {
            transaction.get().setLastUpdated(currentDate);
            transaction.get().setStatus(Statusenum.DELETED.toString());
            transactionRepository.save(transaction.get());
            transactionStatusResponse.setTransactionId(transactionId);
            transactionStatusResponse.setLastUpdated(currentDate.toString());
            transactionStatusResponse.setStatus(Statusenum.DELETED);
        }
        return transactionStatusResponse;

    }


    public List<DirectDebitRequestData> getReadyToProcessDirectDebitTransactions(int batchSize) {

        Pageable pageable = PageRequest.of(0, batchSize);
        List<TransactionEntity> transactionList = transactionRepository.findByNatureAndStatus(DD_COLLECTION, String.valueOf(Statusenum.CREATED), pageable);

        return transactionList.stream()
                .map(transactionEntity -> {
                    try {
                        return transactionDataJpaMapper.mapToDirectDebitRequestData(transactionEntity);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

    public List<CreditTransferRequestData> getReadyToProcessCreditTransferransactions(int batchSize) {

        Pageable pageable = PageRequest.of(0, batchSize);
        List<TransactionEntity> transactionList = transactionRepository.findByNatureAndStatus(CT_COLLECTION, String.valueOf(Statusenum.CREATED), pageable);

        return transactionList.stream()
                .map(transactionEntity -> {
                    try {
                        return transactionDataJpaMapper.mapToCreditTransferRequestData(transactionEntity);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
