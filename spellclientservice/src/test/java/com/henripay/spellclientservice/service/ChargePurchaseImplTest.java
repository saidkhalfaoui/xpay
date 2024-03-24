package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.api.model.ChargePurchaseDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.service.impl.ChargePurchaseImpl;
import com.spell.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChargePurchaseImplTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private SpellConfig spellConfig;

    @InjectMocks
    private ChargePurchaseImpl chargePurchaseService;

    @BeforeEach
    void setUp() {
        chargePurchaseService = new ChargePurchaseImpl(apiClient, spellConfig);
    }

    @Test
    void testDoChargePurchaseSuccess() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        ChargePurchaseDto chargePurchaseDto = new ChargePurchaseDto();
        Purchase purchase = new Purchase();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);

        // Mock the behavior of ApiClient.makeCall() to return a successful response
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(ChargePurchaseDto.class), anyString(), eq(Purchase.class)))
                .thenReturn(purchase);

        // Call the doChargePurchase method
        Purchase result = chargePurchaseService.doChargePurchase(purchaseId, chargePurchaseDto);

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/charge/"), eq(chargePurchaseDto), eq(apiKey), eq(Purchase.class));

        // Assert the result
        assertEquals(purchase, result);
    }

    @Test
    void testDoChargePurchaseFailure() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        ChargePurchaseDto chargePurchaseDto = new ChargePurchaseDto();
        Purchase purchase = new Purchase();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);

        // Mock the behavior of ApiClient.makeCall() to throw an IOException
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(ChargePurchaseDto.class), anyString(), eq(Purchase.class)))
                .thenThrow(new IOException("Failed to charge purchase"));

        // Call the doChargePurchase method and assert that it throws an IOException
        assertThrows(IOException.class, () -> chargePurchaseService.doChargePurchase(purchaseId, chargePurchaseDto));

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/charge/"), eq(chargePurchaseDto), eq(apiKey), eq(Purchase.class));
    }
}