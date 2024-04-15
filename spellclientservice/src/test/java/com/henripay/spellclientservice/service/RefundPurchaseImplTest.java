package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.dto.PurchaseResponseDto;
import com.henripay.spellclientservice.dto.RefundPurchaseDto;
import com.henripay.spellclientservice.mapper.PurchaseResponseMapper;
import com.henripay.spellclientservice.service.impl.RefundPurchaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RefundPurchaseImplTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private SpellConfig spellConfig;

    @Mock
    private PurchaseResponseMapper purchaseResponseMapper;

    @InjectMocks
    private RefundPurchaseImpl refundPurchaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        refundPurchaseService = new RefundPurchaseImpl(apiClient, spellConfig, purchaseResponseMapper);
    }

    @Test
    void testDoRefundPurchaseSuccess() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        RefundPurchaseDto refundPurchaseDto = new RefundPurchaseDto();
        PurchaseResponseDto purchase = new PurchaseResponseDto();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);
        when(purchaseResponseMapper.mapFromJson(anyString())).thenReturn(new PurchaseResponseDto());

        // Mock the behavior of ApiClient.makeCall() to return a successful response
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(RefundPurchaseDto.class), anyString(), eq(String.class)))
                .thenReturn("{}");

        // Call the doRefundPurchase method
        PurchaseResponseDto result = refundPurchaseService.doRefundPurchase(purchaseId, refundPurchaseDto);

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/refund/"), eq(refundPurchaseDto), eq(apiKey), eq(String.class));

        // Assert the result
        assertEquals(purchase, result);
    }

    @Test
    void testDoRefundPurchaseFailure() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";


        RefundPurchaseDto refundPurchaseDto = new RefundPurchaseDto();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);
        when(purchaseResponseMapper.mapFromJson(anyString())).thenReturn(new PurchaseResponseDto());

        // Mock the behavior of ApiClient.makeCall() to throw an IOException
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(RefundPurchaseDto.class), anyString(), eq(String.class)))
                .thenThrow(new IOException("Failed to refund purchase"));

        // Call the doRefundPurchase method and assert that it throws an IOException
        assertThrows(IOException.class, () -> refundPurchaseService.doRefundPurchase(purchaseId, refundPurchaseDto));

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/refund/"), eq(refundPurchaseDto), eq(apiKey), eq(String.class));
    }
}

