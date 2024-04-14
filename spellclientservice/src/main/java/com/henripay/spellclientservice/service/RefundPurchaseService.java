package com.henripay.spellclientservice.service;

import com.henripay.spellclientservice.dto.RefundPurchaseDto;

import java.io.IOException;

public interface RefundPurchaseService {
    Object doRefundPurchase(String purchaseId, RefundPurchaseDto refundPurchaseDto) throws IOException;
}
