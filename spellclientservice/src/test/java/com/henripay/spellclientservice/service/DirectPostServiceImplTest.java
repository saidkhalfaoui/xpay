package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.api.model.DirectPostRequestDto;
import com.henripay.spellclientservice.api.model.DirectPostResponseDto;
import com.henripay.spellclientservice.service.impl.DirectPostServiceImpl;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DirectPostServiceImplTest {

    @Mock
    private ApiClient apiClient;

    @Mock
    private SpellConfig spellConfig;

    @InjectMocks
    private DirectPostServiceImpl directPostService;

    @BeforeEach
    void setUp() {
        directPostService = new DirectPostServiceImpl(apiClient, spellConfig);
    }

    @Test
    void testDoDirectPost() throws IOException {
        // Arrange
        String directPostUrl = "https://example.com/direct-post";
        DirectPostRequestDto requestDto = new DirectPostRequestDto();
        DirectPostResponseDto expectedResponseDto = new DirectPostResponseDto();
        String apiKey = "test-api-key";

        when(spellConfig.getHenriApiKey()).thenReturn(apiKey);
        when(apiClient.makeCall(eq(HttpMethod.POST), eq(directPostUrl + "?s2s=true"), eq(requestDto), eq(apiKey), eq(DirectPostResponseDto.class)))
                .thenReturn(expectedResponseDto);
        // Act
        DirectPostResponseDto actualResponseDto = directPostService.doDirectPost(directPostUrl, requestDto);

        // Assert
        assertEquals(expectedResponseDto, actualResponseDto);
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(directPostUrl + "?s2s=true"), eq(requestDto), eq(apiKey), eq(DirectPostResponseDto.class));
    }

    @Test
    void testDoDirectPostFailure() throws IOException {
        // Mock data
        String directPostUrl = "http://example.com/api";
        String apiKey = "test_api_key";
        DirectPostRequestDto requestDto = new DirectPostRequestDto();

        // Mocking behavior
        when(spellConfig.getHenriApiKey()).thenReturn(apiKey);
        when(apiClient.makeCall(HttpMethod.POST, directPostUrl + "?s2s=true", requestDto, "test_api_key", DirectPostResponseDto.class))
                .thenThrow(new IOException("Failed to make direct post")); // Simulating failure

        // Call the method to be tested and assert that it throws an IOException
        assertThrows(IOException.class, () -> directPostService.doDirectPost(directPostUrl, requestDto));

        // Verify that apiClient.makeCall has been called exactly once
        verify(apiClient, times(1)).makeCall(eq(HttpMethod.POST), eq(directPostUrl + "?s2s=true"), eq(requestDto), eq(apiKey), eq(DirectPostResponseDto.class));
    }
}