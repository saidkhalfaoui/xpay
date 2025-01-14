package com.xpay.spellclientservice.service;

import com.xpay.spellclientservice.api.model.ChargePurchaseDto;
import com.xpay.spellclientservice.api.model.PurchaseResponseDto;
import com.xpay.spellclientservice.apiClient.ApiClient;
import com.xpay.spellclientservice.config.SpellConfig;
import com.xpay.spellclientservice.mapper.PurchaseResponseMapper;
import com.xpay.spellclientservice.service.impl.ChargePurchaseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChargePurchaseServiceImplTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private SpellConfig spellConfig;

    @Mock
    private PurchaseResponseMapper purchaseResponseMapper;

    @InjectMocks
    private ChargePurchaseServiceImpl chargePurchaseService;

    @BeforeEach
    void setUp() {
        chargePurchaseService = new ChargePurchaseServiceImpl(apiClient, spellConfig, purchaseResponseMapper);
    }

    @Test
    void testDoChargePurchaseSuccess() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        ChargePurchaseDto chargePurchaseDto = new ChargePurchaseDto();
        PurchaseResponseDto purchaseResponseDto = new PurchaseResponseDto();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);
        when(purchaseResponseMapper.mapFromJson(anyString())).thenReturn(new PurchaseResponseDto());

        // Mock the behavior of ApiClient.makeCall() to return a successful response
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(ChargePurchaseDto.class), anyString(), eq(String.class)))
                .thenReturn("{}");

        // Call the doChargePurchase method
        // not sure cast works here
        PurchaseResponseDto result = (PurchaseResponseDto) chargePurchaseService.doChargePurchase(purchaseId, chargePurchaseDto);

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/charge/"), eq(chargePurchaseDto), eq(apiKey), eq(String.class));

        // Assert the result
        Assertions.assertEquals(purchaseResponseDto, result);
    }

    @Test
    void testDoChargePurchaseFailure() throws IOException {
        // Mock data
        String purchaseId = "123";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        ChargePurchaseDto chargePurchaseDto = new ChargePurchaseDto();

        // Mocking behavior
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);

        // Mock the behavior of ApiClient.makeCall() to throw an IOException
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(ChargePurchaseDto.class), anyString(), eq(String.class)))
                .thenThrow(new IOException("Failed to charge purchase"));

        // Call the doChargePurchase method and assert that it throws an IOException
        assertThrows(IOException.class, () -> chargePurchaseService.doChargePurchase(purchaseId, chargePurchaseDto));

        // Verify the mock interactions
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl + "/purchases/123/charge/"), eq(chargePurchaseDto), eq(apiKey), eq(String.class));
    }
}
