package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.ChargePurchaseDto;
import com.henripay.spellclientservice.api.model.PurchaseResponseDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.mapper.PurchaseResponseMapper;
import com.henripay.spellclientservice.service.ChargePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChargePurchaseServiceImpl implements ChargePurchaseService {
    private final ApiClient apiClient;
    private final SpellConfig spellConfig;
    private final PurchaseResponseMapper purchaseResponseMapper;

    @Autowired
    public ChargePurchaseServiceImpl(ApiClient apiClient, SpellConfig spellConfig, PurchaseResponseMapper purchaseResponseMapper) {
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
        this.purchaseResponseMapper = purchaseResponseMapper;
    }

    @Override
    public PurchaseResponseDto doChargePurchase(String purchaseId, ChargePurchaseDto chargePurchaseDto) throws IOException {

        String jsonRes = this.apiClient.makeCall(
                HttpMethod.POST,
                this.spellConfig.getBaseUrl()+"/purchases/"+purchaseId+"/charge/",
                chargePurchaseDto,
                this.spellConfig.getApiKey(),
                String.class
        );

        return this.purchaseResponseMapper.mapFromJson(jsonRes);
    }
}
