package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.service.PurchaseService;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final ApiClient<PurchaseRequestDto, Object> apiClient;

    public PurchaseServiceImpl(ApiClient<PurchaseRequestDto, Object> purchaseClient) {
        this.apiClient = purchaseClient;
    }
    @Override
    public Object doPurchase(PurchaseRequestDto requestDto) {
        return this.apiClient.makeCall(requestDto);
    }
}
