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
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void testGetMandateDetails_Exception() {
        // Arrange
        Long mandateId = 1L;
        when(execution.getVariable("mandateId")).thenReturn(mandateId);
        when(mandateClient.getMandateDetails(mandateId)).thenReturn(Mono.error(new RuntimeException("Service unavailable")));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> mandateServiceHandler.getMandateDetails().execute(execution));
    }
}