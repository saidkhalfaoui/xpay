package com.xpay.spellclientservice.service.impl;

import com.xpay.spellclientservice.api.model.PurchaseRequestDto;
import com.xpay.spellclientservice.api.model.PurchaseResponseDto;
import com.xpay.spellclientservice.apiClient.ApiClient;
import com.xpay.spellclientservice.config.SpellConfig;
import com.xpay.spellclientservice.mapper.PurchaseMapper;
import com.xpay.spellclientservice.mapper.PurchaseResponseMapper;
import com.xpay.spellclientservice.service.PurchaseService;
import com.spell.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final ApiClient apiClient;
    private final PurchaseMapper purchaseMapper;
    private final PurchaseResponseMapper purchaseResponseMapper;

    private final SpellConfig spellConfig;

    @Autowired
    public PurchaseServiceImpl(PurchaseMapper purchaseMapper, PurchaseResponseMapper purchaseResponseMapper, ApiClient apiClient, SpellConfig spellConfig) {
        this.purchaseMapper = purchaseMapper;
        this.purchaseResponseMapper = purchaseResponseMapper;
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
    }
    @Override
    public PurchaseResponseDto doPurchase(PurchaseRequestDto requestDto) throws IOException {
        Purchase purchase = this.purchaseMapper.toPurchase(requestDto);
        purchase.setSuccessRedirect(this.spellConfig.getSuccessRedirect());
        purchase.setFailureRedirect(this.spellConfig.getFailureRedirect());

        String  jsonRes =  this.apiClient.makeCall(
                HttpMethod.POST,
                this.spellConfig.getBaseUrl() + "/purchases/",
                purchase,
                this.spellConfig.getApiKey(),
                String.class
                );

        return this.purchaseResponseMapper.mapFromJson(jsonRes);
    }
}
