package com.henripay.henripayapi.service;

import com.henripay.henripayapi.apiClient.ApiClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class UserService {

    private final ApiClient apiClient;
    private final String userServiceUrl;

    public UserService(ApiClient apiClient, AppUrlsConfig appUrlsConfig) {
        this.apiClient = apiClient;
        this.userServiceUrl = appUrlsConfig.getUserServiceUrl();
    }

    public Map<String, Object> getUserDetails(Integer userId) throws RestClientException, IOException {
        String getUserDetailsUrl = this.userServiceUrl + "/users/" + userId;
        return this.apiClient.makeCall(HttpMethod.GET, getUserDetailsUrl, null, Map.class);
    }
}
