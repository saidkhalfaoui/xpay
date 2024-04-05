package com.henripay.sepadd.dataaccess.model;

import com.google.common.collect.Maps;
import com.henripay.sepadd.api.model.DirectDebitRequestData;

import java.util.Map;

public class DirectDebitJsonObjectMapper extends TransactionJsonObjectMapper {
    public static Map<String, Object> toHashMap(DirectDebitRequestData directDebitRequestData) {
        Map<String, Object> data = Maps.newHashMap();

//        data.put(ACCOUNT_INFO, directDebitRequestData.getAccountInfo());
//        data.put(END_TO_END_REFERENCE, directDebitRequestData.getEndToEndTransactionReference());
//        data.put(AMOUNT, directDebitRequestData.getAmount());
//        data.put(MANDATE_INFORMATION, directDebitRequestData.getMandateInformation());
//        data.put(TRANSACTION_TYPE, directDebitRequestData.getTransactionType());
//        data.put(SCHEDULED_EXECUTION_DATE, directDebitRequestData.getScheduledExecutionDate());
//        data.put(CREATION_DATE, directDebitRequestData.getCreationDate());
//        data.put(STATUS, directDebitRequestData.getStatus());
//        data.put(ProcessingStatus, directDebitRequestData.getProcessingStatus());
//        data.put(LAST_UPDATED, directDebitRequestData.getLastUpdated());

        return data;

    }


}
