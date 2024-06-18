package com.xpay.spellclientservice.service;


import com.xpay.spellclientservice.api.model.PurchaseRequestDto;

import java.io.IOException;

public interface PurchaseService {
    Object doPurchase(PurchaseRequestDto requestDto) throws IOException;
}
