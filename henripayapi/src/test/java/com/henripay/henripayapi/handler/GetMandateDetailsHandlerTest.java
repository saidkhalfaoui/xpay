package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.service.MandateService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetMandateDetailsHandlerTest {

    @Mock
    private MandateService mandateService;

    @Mock
    private DelegateExecution execution;

    private GetMandateDetailsHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GetMandateDetailsHandler(mandateService);
    }

    @Test
    void testGetMandateDetails() throws Exception {
        // Arrange
        int mandateId = 123;
        Map<String, Object> expectedMandateDetails = new HashMap<>();
        expectedMandateDetails.put("id", mandateId);
        expectedMandateDetails.put("status", "active");

        when(execution.getVariable("mandateId")).thenReturn(mandateId);
        when(mandateService.getMandateDetails(mandateId)).thenReturn(expectedMandateDetails);

        // Act
        handler.getMandateDetails().execute(execution);

        // Assert
        verify(mandateService, times(1)).getMandateDetails(mandateId);
        verify(execution, times(1)).setVariable("mandateDetails", expectedMandateDetails);
    }

    @Test
    void testGetMandateDetailsWithException() throws IOException {
        // Arrange
        int mandateId = 123;
        when(execution.getVariable("mandateId")).thenReturn(mandateId);
        when(mandateService.getMandateDetails(mandateId)).thenThrow(new IOException());

        // Act & Assert
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> handler.getMandateDetails().execute(execution));
        verify(mandateService, times(1)).getMandateDetails(mandateId);
    }
}
