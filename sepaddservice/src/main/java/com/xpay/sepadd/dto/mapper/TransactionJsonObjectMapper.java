package com.xpay.sepadd.dto.mapper;

import java.util.HashMap;

public class TransactionJsonObjectMapper {
    private static final HashMap<String, Object> propertyMap = new HashMap<>();


    public static final String IBAN = "iban";
    public static final String ACCOUNT_INFO = "accountInfo";


    public static final String ADDRESS = "address";
    public static final String END_TO_END_REFERENCE = "endToEndTransactionReference";
    public static final String REMITTANCE_INFO = "remittanceInfo";

    public static final String AMOUNT = "amount";


    public static final String MANDATE_INFORMATION = "mandateInformation";
    public static final String TRANSACTION_TYPE = "transactionType";

    public static final String SCHEDULED_EXECUTION_DATE = "scheduledExecutionDate";
    public static final String LAST_UPDATED = "lastUpdated";
    public static final String CREATION_DATE = "creationDate";
    public static final String STATUS = "status";
    public static final String ProcessingStatus = "processingStatus";


}
