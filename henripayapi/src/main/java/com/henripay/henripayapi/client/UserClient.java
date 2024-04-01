package com.henripay.henripayapi.client;

import com.henripay.henripayapi.apiClient.ApiClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import com.henripay.henripayapi.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class UserClient {

    private final ApiClient apiClient;
    private final String userServiceUrl;

    public UserClient(ApiClient apiClient, AppUrlsConfig appUrlsConfig) {
        this.apiClient = apiClient;
        this.userServiceUrl = appUrlsConfig.getUserServiceUrl();
    }

    public UserDTO getUserDetails(Long userId) throws RestClientException, IOException {
        String getUserDetailsUrl = this.userServiceUrl + "/users/" + userId;
        return this.apiClient.makeCall(HttpMethod.GET, getUserDetailsUrl, null, UserDTO.class);
    }
}
