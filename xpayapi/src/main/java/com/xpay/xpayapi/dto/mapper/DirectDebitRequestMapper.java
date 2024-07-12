package com.xpay.xpayapi.dto.mapper;

import com.xpay.xpayapi.dto.*;

import java.math.BigDecimal;

public class DirectDebitRequestMapper {

    public static DirectDebitRequest mapToDirectDebitRequest(String processId ,DirectDebitRequest directDebitRequest, Collectioninformation collectionInformation, MandateDTO mandateDetails, UserDTO userDetails) {

        directDebitRequest.setTransactionType(Transactiontype.FINAL); //todo: set correct transaction type
        directDebitRequest.setAmount(BigDecimal.valueOf(collectionInformation.getAmount()));
        directDebitRequest.setCurrency(collectionInformation.getCurrency());
        //todo: see if we need to set the following fields

        var mandateinformationRequest = new MandateinformationRequest();
        mandateinformationRequest.setMandateId(mandateDetails.getMandateIdentifier().toString()); //todo: set correct mandate id type
        mandateinformationRequest.setPersonId(mandateDetails.getCustomer().toString()); //todo: set correct customer id type
        directDebitRequest.setMandateInformation(mandateinformationRequest);
        //todo: see if we need to set the following fields

        var accountinformationRequest = new AccountinformationRequest();
        accountinformationRequest.setIBAN(userDetails.getIban());
        accountinformationRequest.setName(userDetails.getFullName());
        var address = new Address();
        //todo: set correct address fields
        accountinformationRequest.setAddress(address);
        //todo: see if we need to set the following fields

        //
        directDebitRequest.setAccountInfo(accountinformationRequest);

        //todo: see if we need to set the following fields
        directDebitRequest.endToEndTransactionReference(processId);

        return directDebitRequest;
    }
}
