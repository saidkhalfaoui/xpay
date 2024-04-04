package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.MandateClient;
import com.henripay.henripayapi.dto.MandateDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MandateServiceHandlerTest {

    @Mock
    private MandateClient mandateClient;

    @Mock
    private DelegateExecution execution;

    private MandateServiceHandler mandateServiceHandler;

    @BeforeEach
    public void setup() {
        mandateServiceHandler = new MandateServiceHandler(mandateClient);
    }

    @Test
    public void testGetMandateDetails_Success() throws Exception {
        // Arrange
        Long mandateId = 1L;
        MandateDTO expectedMandateDTO = new MandateDTO();
        when(execution.getVariable("mandateId")).thenReturn(mandateId);
        when(mandateClient.getMandateDetails(mandateId)).thenReturn(Mono.just(expectedMandateDTO));

        // Act
        mandateServiceHandler.getMandateDetails().execute(execution);

        // Assert
        verify(execution, times(1)).setVariable("mandateDetails", expectedMandateDTO);
    }

    @Test
    public void testGetMandateDetails_Exception() throws Exception {
        // Arrange
        Long mandateId = 1L;
        when(execution.getVariable("mandateId")).thenReturn(mandateId);
        when(mandateClient.getMandateDetails(mandateId)).thenReturn(Mono.error(new RuntimeException("Service unavailable")));

        // Act & Assert
        // The test should not throw an exception since the exception is caught in the method
        mandateServiceHandler.getMandateDetails().execute(execution);
    }
}