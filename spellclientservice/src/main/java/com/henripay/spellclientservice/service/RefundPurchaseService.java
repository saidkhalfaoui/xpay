package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.api.model.RefundPurchaseDto;

import java.io.IOException;

public interface RefundPurchaseService {
    Object doRefundPurchase(String purchaseId, RefundPurchaseDto refundPurchaseDto) throws IOException;
}
