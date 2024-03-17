package com.henripay.spellclientservice.service;


import com.henripay.spellclientservice.api.model.PurchaseRequestDto;

public interface PurchaseService {
    Object doPurchase(PurchaseRequestDto requestDto);
}
