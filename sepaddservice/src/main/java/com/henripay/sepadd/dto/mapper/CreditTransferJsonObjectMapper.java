package com.henripay.sepadd.dto.mapper;

import com.google.common.collect.Maps;
import com.henripay.sepadd.dto.CreditTransferRequestData;

import java.util.Map;

public class CreditTransferJsonObjectMapper extends TransactionJsonObjectMapper {

    public static Map<String, Object> toHashMap(CreditTransferRequestData creditTransferRequestData) {
        Map<String, Object> data = Maps.newHashMap();

        data.put(ACCOUNT_INFO, creditTransferRequestData.getAccountInfo());
        //  data.put (END_TO_END_REFERENCE , creditTransferRequestData.);
        data.put(AMOUNT, creditTransferRequestData.getAmount());
        data.put(END_TO_END_REFERENCE, creditTransferRequestData.getEndToEndTransactionReference());
        data.put(REMITTANCE_INFO, creditTransferRequestData.getRemittanceInfo());
        // data.put(MANDATE_INFORMATION , creditTransferRequestData.getMandateInformation());
        //data.put(TRANSACTION_TYPE , creditTransferRequestData.getTransactionType());
        data.put(SCHEDULED_EXECUTION_DATE, creditTransferRequestData.getScheduledExecutionDate());
        data.put(CREATION_DATE, creditTransferRequestData.getCreationDate());
        data.put(STATUS, creditTransferRequestData.getStatus());
        data.put(ProcessingStatus, creditTransferRequestData.getProcessingStatus());
        data.put(LAST_UPDATED, creditTransferRequestData.getLastUpdated());

        return data;

    }
}
