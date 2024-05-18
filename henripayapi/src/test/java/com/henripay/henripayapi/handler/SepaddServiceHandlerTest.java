package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.SepaddClient;
import com.henripay.henripayapi.dto.CreditTransferRequest;
import com.henripay.henripayapi.dto.DirectDebitRequest;
import com.henripay.henripayapi.dto.TransactionResponse;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.eclipse.persistence.config.CacheUsageIndirectionPolicy.Exception;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SepaddServiceHandlerTest {

    @Mock
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
        TransactionResponse expectedResponse = new TransactionResponse();
        when(execution.getVariable("directDebitRequest")).thenReturn(directDebitRequest);
        when(sepaddClient.addDirectDebitTransaction(directDebitRequest)).thenReturn(expectedResponse);

        // Act
        sepaddServiceHandler.addDirectDebitTransaction().execute(execution);

        // Assert
        verify(execution, times(1)).setVariable("addDirectDebitTransactionResponse", expectedResponse);
    }

    @Test
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
    @Test
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
