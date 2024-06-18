package com.xpay.xpayapi.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpay.xpayapi.client.SepaddClient;
import com.xpay.xpayapi.dto.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.eclipse.persistence.config.CacheUsageIndirectionPolicy.Exception;
import  static  org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;




@ExtendWith(MockitoExtension.class)


public class SepaddServiceHandlerTest  {




    @Mock(strictness = Mock.Strictness.LENIENT)
    private SepaddClient sepaddClient;

    @Mock
    private DelegateExecution execution;

    private SepaddServiceHandler sepaddServiceHandler;

    @BeforeEach
    public void setup() {
        sepaddServiceHandler = new SepaddServiceHandler(sepaddClient);
    }

    @Test

    public void testAddDirectDebitTransaction_Success() throws Exception {
        // Arrange
        DirectDebitRequest directDebitRequest = new DirectDebitRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/collection.json");
        Collectioninformation collectionInformation = null;
        try {
            collectionInformation = objectMapper.readValue(jsonFile, Collectioninformation.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        MandateDTO mandateDetails= new MandateDTO();
        mandateDetails.setMandateIdentifier(1234567L);
        mandateDetails.setCustomer(1234456L);

        UserDTO userDetails = new UserDTO();
        userDetails.setCustomerIdIdentifier(1234567L);
        userDetails.setIban("NLINGB79879823654");
        TransactionResponse transactionResponse= new TransactionResponse();
        transactionResponse.setTransactionId("da65edw74sdas");
        transactionResponse.setStatus(Statusenum.CREATED);
        TransactionResponse expectedResponse = new TransactionResponse();
        when(execution.getVariable("collectionInformation")).thenReturn(collectionInformation);
        when(execution.getVariable("mandateDetails")).thenReturn(mandateDetails);
        when(execution.getVariable("userDetails")).thenReturn(userDetails);
        when(sepaddClient.addDirectDebitTransaction(any(DirectDebitRequest.class)))
                .thenReturn(transactionResponse);


        // Act
        sepaddServiceHandler.addDirectDebitTransaction().execute(execution);

        // Assert
        verify(execution, times(1)).setVariable("transactionResponse", transactionResponse);
    }




    @Ignore

    public void testAddCreditTransferTransaction_Success() throws Exception {
        // Arrange
        CreditTransferRequest creditTransferRequest = new CreditTransferRequest();
        TransactionResponse expectedResponse = new TransactionResponse();
        when(execution.getVariable("creditTransferRequest")).thenReturn(creditTransferRequest);
        when(sepaddClient.addCreditTransaction(creditTransferRequest)).thenReturn(expectedResponse);

        // Act
        sepaddServiceHandler.addCreditTransferTransaction().execute(execution);

        // Assert
        verify(execution, times(1)).setVariable("addCreditTransactionResponse", expectedResponse);
    }

    @Ignore

    public void testCancelAddDirectDebitTransaction_Success() throws Exception {
        // Arrange
        String transactionId = "12345";
        TransactionResponse expectedResponse = new TransactionResponse();
        when(execution.getVariable("transactionId")).thenReturn(transactionId);
        when(sepaddClient.deleteTransaction(transactionId)).thenReturn(expectedResponse);

        // Act
        sepaddServiceHandler.cancelAddDirectDebitTransaction().execute(execution);

        // Assert
        verify(execution, times(1)).setVariable("deleteTransactionResponse", expectedResponse);
    }
}
