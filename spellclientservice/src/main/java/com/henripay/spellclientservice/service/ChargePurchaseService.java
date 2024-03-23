package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.api.model.ChargePurchaseDto;

import java.io.IOException;

public interface ChargePurchaseService {
    Object doChargePurchase(String purchaseId, ChargePurchaseDto chargePurchaseDto) throws IOException;
}
