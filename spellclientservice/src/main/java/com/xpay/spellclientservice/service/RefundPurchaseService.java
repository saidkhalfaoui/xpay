package com.xpay.spellclientservice.service;

import com.xpay.spellclientservice.api.model.RefundPurchaseDto;

import java.io.IOException;

public interface RefundPurchaseService {
    Object doRefundPurchase(String purchaseId, RefundPurchaseDto refundPurchaseDto) throws IOException;
}
