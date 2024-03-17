package com.henripay.spellclientservice.apiClient.impl;

import com.henripay.spellclientservice.api.model.DirectPostRequestDto;
import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DirectPostApiClient implements ApiClient<DirectPostRequestDto, Object> {

    private final RestTemplate restTemplate;

    @Autowired
    public DirectPostApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Object makeCall(DirectPostRequestDto params) {
        ResponseEntity<Object> response = restTemplate.postForEntity("https://payments.henripay.com/p/", params, Object.class);
        return response.getBody();
    }
}
