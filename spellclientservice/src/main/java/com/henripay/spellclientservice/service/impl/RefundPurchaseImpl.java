package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.RefundPurchaseDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.service.RefundPurchaseService;
import com.spell.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RefundPurchaseImpl implements RefundPurchaseService {
    private final ApiClient apiClient;
    private final SpellConfig spellConfig;

    @Autowired
    public RefundPurchaseImpl(ApiClient apiClient, SpellConfig spellConfig) {
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
    }
    @Override
    public Purchase doRefundPurchase(String purchaseId, RefundPurchaseDto refundPurchaseDto) throws IOException {
        return this.apiClient.makeCall(
                HttpMethod.POST,
                this.spellConfig.getBaseUrl()+"/purchases/"+purchaseId+"/refund/",
                refundPurchaseDto,
                this.spellConfig.getApiKey(),
                Purchase.class
        );
    }
}
