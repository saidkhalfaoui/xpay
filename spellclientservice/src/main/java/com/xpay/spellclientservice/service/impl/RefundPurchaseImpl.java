package com.xpay.spellclientservice.service.impl;

import com.xpay.spellclientservice.api.model.PurchaseResponseDto;
import com.xpay.spellclientservice.api.model.RefundPurchaseDto;
import com.xpay.spellclientservice.apiClient.ApiClient;
import com.xpay.spellclientservice.config.SpellConfig;
import com.xpay.spellclientservice.mapper.PurchaseResponseMapper;
import com.xpay.spellclientservice.service.RefundPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RefundPurchaseImpl implements RefundPurchaseService {
    private final ApiClient apiClient;
    private final SpellConfig spellConfig;
    private final PurchaseResponseMapper purchaseResponseMapper;

    @Autowired
    public RefundPurchaseImpl(ApiClient apiClient, SpellConfig spellConfig,PurchaseResponseMapper purchaseResponseMapper) {
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }
    @Override
    public PurchaseResponseDto doRefundPurchase(String purchaseId, RefundPurchaseDto refundPurchaseDto) throws IOException {
        String jsonRes = this.apiClient.makeCall(
                HttpMethod.POST,
                this.spellConfig.getBaseUrl()+"/purchases/"+purchaseId+"/refund/",
                refundPurchaseDto,
                this.spellConfig.getApiKey(),
                String.class
        );

        return this.purchaseResponseMapper.mapFromJson(jsonRes);
    }
}
