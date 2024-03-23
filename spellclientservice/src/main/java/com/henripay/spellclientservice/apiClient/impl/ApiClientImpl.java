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
    public <T, R> R makeCall(HttpMethod httpMethod, String url, T params, String apiKey, Class<R> responseType) throws IOException {
        String reqBody = HttpReqHelper.castToReqBody(params);

        ResponseEntity<R> response = restTemplate.exchange(
                url,
                httpMethod,
                HttpReqHelper.prepReqEntity(reqBody, apiKey),
                responseType
        );

        return response.getBody();
    }
}
