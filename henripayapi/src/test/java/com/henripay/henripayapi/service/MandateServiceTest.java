package com.henripay.henripayapi.service;

import com.henripay.henripayapi.apiClient.ApiClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MandateServiceTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private AppUrlsConfig appUrlsConfig;

    private MandateService mandateService;

    @BeforeEach
    void setUp() {
        when(appUrlsConfig.getMandateServiceUrl()).thenReturn("http://example.com/mandate-service");
        mandateService = new MandateService(apiClient, appUrlsConfig);
    }

    @Test
    void testGetMandateDetails() throws IOException, RestClientException {
        // Arrange
        int mandateId = 123;
        Map<String, Object> expectedMandateDetails = new HashMap<>();
        expectedMandateDetails.put("id", mandateId);
        expectedMandateDetails.put("status", "active");

        String getMandateDetailsUrl = "http://example.com/mandate-service/mandates/" + mandateId;
        when(apiClient.makeCall(HttpMethod.GET, getMandateDetailsUrl, null, Map.class))
                .thenReturn(expectedMandateDetails);

        // Act
        Map<String, Object> actualMandateDetails = mandateService.getMandateDetails(mandateId);

        // Assert
        assertEquals(expectedMandateDetails, actualMandateDetails);
        verify(apiClient, times(1)).makeCall(HttpMethod.GET, getMandateDetailsUrl, null, Map.class);
    }

    @Test
    void testGetMandateDetailsWithException() throws IOException, RestClientException {
        // Arrange
        int mandateId = 123;
        String getMandateDetailsUrl = "http://example.com/mandate-service/mandates/" + mandateId;
        when(apiClient.makeCall(HttpMethod.GET, getMandateDetailsUrl, null, Map.class))
                .thenThrow(new RestClientException("API client error"));

        // Act & Assert
        org.junit.jupiter.api.Assertions.assertThrows(RestClientException.class, () -> mandateService.getMandateDetails(mandateId));
        verify(apiClient, times(1)).makeCall(HttpMethod.GET, getMandateDetailsUrl, null, Map.class);
    }
}