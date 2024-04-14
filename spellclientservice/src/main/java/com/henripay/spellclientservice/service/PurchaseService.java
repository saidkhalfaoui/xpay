package com.henripay.spellclientservice.service;


import com.henripay.spellclientservice.dto.PurchaseRequestDto;

import java.io.IOException;

public interface PurchaseService {
    Object doPurchase(PurchaseRequestDto requestDto) throws IOException;
}
