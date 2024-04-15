package com.henripay.spellclientservice.service;


import com.henripay.spellclientservice.api.model.PurchaseRequestDto;

import java.io.IOException;

public interface PurchaseService {
    Object doPurchase(PurchaseRequestDto requestDto) throws IOException;
}
