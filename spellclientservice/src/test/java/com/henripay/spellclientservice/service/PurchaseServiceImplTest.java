package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.dto.PurchaseRequestDto;
import com.henripay.spellclientservice.dto.PurchaseResponseDto;
import com.henripay.spellclientservice.mapper.PurchaseMapper;
import com.henripay.spellclientservice.mapper.PurchaseResponseMapper;
import com.henripay.spellclientservice.service.impl.PurchaseServiceImpl;
import com.spell.model.Purchase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private PurchaseMapper purchaseMapper;

    @Mock
    private PurchaseResponseMapper purchaseResponseMapper;

    @Mock
    private SpellConfig spellConfig;

    @InjectMocks
    private PurchaseServiceImpl purchaseService;

    private PurchaseRequestDto requestDto;
    private Purchase expectedPurchase;

    @BeforeEach
    public void setUp() {
        requestDto = new PurchaseRequestDto();
        expectedPurchase = new Purchase();
        purchaseService = new PurchaseServiceImpl(purchaseMapper, purchaseResponseMapper, apiClient, spellConfig);
    }

    @Test
    public void testDoPurchaseSuccessful() throws Exception {
        String successRedirect = "https://success.example.com";
        String failureRedirect = "https://failure.example.com";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        // Mock the behavior of the mappers
        when(purchaseMapper.toPurchase(requestDto)).thenReturn(expectedPurchase);
        when(purchaseResponseMapper.mapFromJson(anyString())).thenReturn(new PurchaseResponseDto());

        // Mock the behavior of SpellConfig
        when(spellConfig.getSuccessRedirect()).thenReturn(successRedirect);
        when(spellConfig.getFailureRedirect()).thenReturn(failureRedirect);
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);

        // Mock the behavior of ApiClient.makeCall()
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(Purchase.class), anyString(), eq(String.class)))
                .thenReturn("{}");

        // Call the doPurchase method
        PurchaseResponseDto result = purchaseService.doPurchase(requestDto);

        // Verify the result
        // Add assertions to verify the result against the expectedPurchase

        //assertEquals();
        // Verify the mock interactions
        verify(purchaseMapper, times(1)).toPurchase(requestDto);
        verify(spellConfig, times(1)).getSuccessRedirect();
        verify(spellConfig, times(1)).getFailureRedirect();
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl+"/purchases/"), eq(expectedPurchase), eq(apiKey), eq(String.class));

    }

    @Test
    public void testDoPurchaseFailure() throws Exception {
        String successRedirect = "https://success.example.com";
        String failureRedirect = "https://failure.example.com";
        String baseUrl = "https://api.example.com";
        String apiKey = "api-key";

        // Mock the behavior of the mappers
        when(purchaseMapper.toPurchase(requestDto)).thenReturn(expectedPurchase);

        // Mock the behavior of SpellConfig
        when(spellConfig.getSuccessRedirect()).thenReturn(successRedirect);
        when(spellConfig.getFailureRedirect()).thenReturn(failureRedirect);
        when(spellConfig.getBaseUrl()).thenReturn(baseUrl);
        when(spellConfig.getApiKey()).thenReturn(apiKey);

        // Mock the behavior of ApiClient.makeCall() to throw an IOException
        when(apiClient.makeCall(any(HttpMethod.class), anyString(), any(Purchase.class), anyString(), eq(String.class)))
                .thenThrow(new IOException("Failed to make the purchase"));

        // Call the doPurchase method and assert that it throws an IOException
        assertThrows(IOException.class, () -> purchaseService.doPurchase(requestDto));

        // Verify the mock interactions
        verify(purchaseMapper, times(1)).toPurchase(requestDto);
        verify(spellConfig, times(1)).getSuccessRedirect();
        verify(spellConfig, times(1)).getFailureRedirect();
        verify(spellConfig, times(1)).getBaseUrl();
        verify(spellConfig, times(1)).getApiKey();
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(baseUrl+"/purchases/"), eq(expectedPurchase), eq(apiKey), eq(String.class));
    }
}