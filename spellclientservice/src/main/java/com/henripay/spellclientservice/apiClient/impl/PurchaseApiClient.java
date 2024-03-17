package com.henripay.spellclientservice.apiClient.impl;

import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PurchaseApiClient implements ApiClient<PurchaseRequestDto, Object> {

    private final RestTemplate restTemplate;

    @Autowired
    public PurchaseApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Object makeCall(PurchaseRequestDto params) {
        // the URL will be extracted from here
        ResponseEntity<Object> response = restTemplate.postForEntity("https://gate.henripay.com/api/v1/purchases/", params, Object.class);
        return response.getBody();
    }
}
