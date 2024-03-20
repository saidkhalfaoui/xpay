package com.henripay.spellclientservice.apiClient.impl;

import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.util.HttpReqHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class ApiClientImpl implements ApiClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> Object makeCall(HttpMethod httpMethod, String url, T params, String apiKey) throws IOException {
        String reqBody = HttpReqHelper.castToReqBody(params);

        ResponseEntity<Object> response = restTemplate.exchange(
                url,
                httpMethod,
                HttpReqHelper.prepReqEntity(reqBody, apiKey),
                Object.class
        );

        return response.getBody();
    }
}
