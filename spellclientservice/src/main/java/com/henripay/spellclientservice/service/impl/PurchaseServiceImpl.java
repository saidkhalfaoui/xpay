package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.mapper.PurchaseMapper;
import com.henripay.spellclientservice.service.PurchaseService;
import com.spell.PaymentApi;
import com.spell.model.ClientDetails;
import com.spell.model.Product;
import com.spell.model.Purchase;
import com.spell.model.PurchaseDetails;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final ApiClient apiClient;
    private final PurchaseMapper purchaseMapper;

    private final SpellConfig spellConfig;


    public PurchaseServiceImpl(PurchaseMapper purchaseMapper, ApiClient apiClient, SpellConfig spellConfig) {
        this.purchaseMapper = purchaseMapper;
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
    }
    @Override
    public Object doPurchase(PurchaseRequestDto requestDto) throws IOException {
        Purchase purchase = this.purchaseMapper.toPurchase(requestDto);
        purchase.setSuccessRedirect(this.spellConfig.getSuccessRedirect());
        purchase.setFailureRedirect(this.spellConfig.getFailureRedirect());

        return this.apiClient.makeCall(
                HttpMethod.POST,
                this.spellConfig.getBaseUrl() + "/purchases/",
                purchase,
                this.spellConfig.getApiKey());
    }
}
