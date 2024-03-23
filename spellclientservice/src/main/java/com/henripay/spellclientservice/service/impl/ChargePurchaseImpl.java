package com.henripay.spellclientservice.service.impl;

import com.henripay.spellclientservice.api.model.ChargePurchaseDto;
import com.henripay.spellclientservice.apiClient.ApiClient;
import com.henripay.spellclientservice.config.SpellConfig;
import com.henripay.spellclientservice.service.ChargePurchaseService;
import com.spell.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChargePurchaseImpl implements ChargePurchaseService {
    private final ApiClient apiClient;
    private final SpellConfig spellConfig;

    @Autowired
    public ChargePurchaseImpl(ApiClient apiClient, SpellConfig spellConfig) {
        this.apiClient = apiClient;
        this.spellConfig = spellConfig;
    }

    @Override
    public Purchase doChargePurchase(String purchaseId, ChargePurchaseDto chargePurchaseDto) throws IOException {

        Purchase purchase = this.apiClient.makeCall(
                HttpMethod.POST,
                this.spellConfig.getBaseUrl()+"/purchases/"+purchaseId+"/charge/",
                chargePurchaseDto,
                this.spellConfig.getApiKey(),
                Purchase.class
        );
        return purchase;
    }
}
