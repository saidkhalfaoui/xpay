package com.henripay.henripayapi.service;

import com.henripay.henripayapi.apiClient.ApiClient;
import com.henripay.henripayapi.client.UserClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserClientTest {

    @Mock
    private ApiClient apiClient;

    private UserClient userClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        AppUrlsConfig appUrlsConfig = new AppUrlsConfig();
        appUrlsConfig.setUserServiceUrl("http://example.com");
        userClient = new UserClient(apiClient, appUrlsConfig);
    }

    @Test
    void testGetUserDetails_Success() throws IOException {
        // Arrange
        Integer userId = 123;
        String expectedUrl = "http://example.com/users/123";
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("id", userId);
        userDetails.put("name", "John Doe");
        userDetails.put("IBAN", "CH93 0076 2011 6238 5295 7");
        when(apiClient.makeCall(HttpMethod.GET, expectedUrl, null, Map.class)).thenReturn(userDetails);

        // Act
        Map<String, Object> result = userClient.getUserDetails(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.get("id"));
        assertEquals("John Doe", result.get("name"));
    }

    @Test
    void testGetUserDetails_RestClientException() throws IOException {
        // Arrange
        Integer userId = 123;
        when(apiClient.makeCall(any(), any(), any(), any())).thenThrow(new RestClientException("Error"));

        // Act and Assert
        assertThrows(RestClientException.class, () -> userClient.getUserDetails(userId));
    }
}

