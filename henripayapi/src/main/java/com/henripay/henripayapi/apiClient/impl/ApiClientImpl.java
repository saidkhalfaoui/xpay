package com.henripay.henripayapi.apiClient.impl;

import com.henripay.henripayapi.apiClient.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Component
public class ApiClientImpl implements ApiClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T, R> R makeCall(HttpMethod httpMethod, String url, T params, Class<R> responseType) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<R> response = restTemplate.exchange(
                url,
                httpMethod,
                new HttpEntity<>(params, headers),
                responseType
        );

        return response.getBody();
    }

}
