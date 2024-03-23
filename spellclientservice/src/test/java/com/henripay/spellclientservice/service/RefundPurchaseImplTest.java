package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.api.model.RefundPurchaseDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.service.impl.RefundPurchaseImpl;
import com.spell.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RefundPurchaseImplTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private SpellConfig spellConfig;

    @InjectMocks
    private RefundPurchaseImpl refundPurchaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        refundPurchaseService = new RefundPurchaseImpl(apiClient, spellConfig);
    }

    @Test
    void testDoRefundPurchaseSuccess() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        RefundPurchaseDto refundPurchaseDto = new RefundPurchaseDto();
        Purchase purchase = new Purchase();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);

        // Mock the behavior of ApiClient.makeCall() to return a successful response
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(RefundPurchaseDto.class), anyString(), eq(Purchase.class)))
                .thenReturn(purchase);

        // Call the doRefundPurchase method
        Purchase result = refundPurchaseService.doRefundPurchase(purchaseId, refundPurchaseDto);

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/refund/"), eq(refundPurchaseDto), eq(apiKey), eq(Purchase.class));

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

        // Mock the behavior of ApiClient.makeCall() to throw an IOException
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(RefundPurchaseDto.class), anyString(), eq(Purchase.class)))
                .thenThrow(new IOException("Failed to refund purchase"));

        // Call the doRefundPurchase method and assert that it throws an IOException
        assertThrows(IOException.class, () -> refundPurchaseService.doRefundPurchase(purchaseId, refundPurchaseDto));

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/refund/"), eq(refundPurchaseDto), eq(apiKey), eq(Purchase.class));
    }
}

