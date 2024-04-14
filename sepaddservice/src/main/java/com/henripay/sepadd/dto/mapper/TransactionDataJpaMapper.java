package com.henripay.sepadd.dto.mapper;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.sepadd.dto.*;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TransactionDataJpaMapper {


    public DirectDebitRequestData mapToDirectDebitRequestData(TransactionEntity transaction) throws IOException {
        DirectDebitRequestData directDebitRequestData = new DirectDebitRequestData();
        ObjectMapper objectMapper = new ObjectMapper();

        directDebitRequestData.setAmount(transaction.getAmount());
        directDebitRequestData.setCurrency(transaction.getCurrency());
        directDebitRequestData.setScheduledExecutionDate(transaction.getScheduledExecutionDate());
        directDebitRequestData.setEndToEndTransactionReference(transaction.getEndToEndTransactionReference());
        directDebitRequestData.setAuthorisation1Code(transaction.getAuthorisation1Code());
        directDebitRequestData.setTransactionType(Transactiontype.valueOf(transaction.getTransactionType()));
        directDebitRequestData.setInternalTransactionReference(transaction.getInternalTransactionReference());
        directDebitRequestData.setStatus(Statusenum.valueOf(transaction.getStatus()));
        directDebitRequestData.setProcessingStatus(Processingstatusenum.valueOf(transaction.getProcessingStatus()));
        directDebitRequestData.setCreationDate(transaction.getCreationDate());
        directDebitRequestData.setLastUpdated(transaction.getLastUpdated());

        JsonNode accountInfoNode = objectMapper.readTree(transaction.getAccountInfo());
        Accountinformation accountInformation = objectMapper.treeToValue(accountInfoNode, Accountinformation.class);
        directDebitRequestData.setAccountInfo(accountInformation);

        JsonNode mandateInfoNode = objectMapper.readTree(transaction.getMandateInformation());
        Mandateinformation mandateInformation = objectMapper.treeToValue(mandateInfoNode, Mandateinformation.class);
        directDebitRequestData.setMandateInformation(mandateInformation);

        return directDebitRequestData;
    }

    public CreditTransferRequestData mapToCreditTransferRequestData(TransactionEntity transaction) throws IOException {

        CreditTransferRequestData creditTransferRequestData = new CreditTransferRequestData();
        ObjectMapper objectMapper = new ObjectMapper();

        creditTransferRequestData.setAmount(transaction.getAmount());
        creditTransferRequestData.setCurrency(transaction.getCurrency());
        creditTransferRequestData.setScheduledExecutionDate(transaction.getScheduledExecutionDate());
        creditTransferRequestData.setEndToEndTransactionReference(transaction.getEndToEndTransactionReference());
        creditTransferRequestData.setAdditionalInfo(transaction.getAdditionalInfo());
        creditTransferRequestData.setRemittanceInfo(transaction.getRemittanceInfo());
        creditTransferRequestData.setStatus(Statusenum.valueOf(transaction.getStatus()));
        creditTransferRequestData.setProcessingStatus(Processingstatusenum.valueOf(transaction.getProcessingStatus()));
        creditTransferRequestData.setCreationDate(transaction.getCreationDate());
        creditTransferRequestData.setLastUpdated(transaction.getLastUpdated());

        JsonNode accountInfoNode = objectMapper.readTree(transaction.getAccountInfo());
        Accountinformation accountInformation = objectMapper.treeToValue(accountInfoNode, Accountinformation.class);
        creditTransferRequestData.setAccountInfo(accountInformation);

        return creditTransferRequestData;
    }
}
