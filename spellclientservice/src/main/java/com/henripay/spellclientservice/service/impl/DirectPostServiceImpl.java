package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.DirectPostRequestDto;
import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.service.DirectPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectPostServiceImpl implements DirectPostService {

    private final ApiClient<DirectPostRequestDto, Object> apiClient;

    @Autowired
    public DirectPostServiceImpl(ApiClient<DirectPostRequestDto, Object> apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Object doDirectPost(DirectPostRequestDto directPostRequestDto) {
        return this.apiClient.makeCall(directPostRequestDto);
    }
}
