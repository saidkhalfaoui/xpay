package com.xpay.spellclientservice.service;

import com.xpay.spellclientservice.api.model.ChargePurchaseDto;

import java.io.IOException;

public interface ChargePurchaseService {
    Object doChargePurchase(String purchaseId, ChargePurchaseDto chargePurchaseDto) throws IOException;
}
