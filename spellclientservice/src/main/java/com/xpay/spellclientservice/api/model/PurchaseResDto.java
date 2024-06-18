package com.xpay.spellclientservice.api.model;

import com.spell.model.ClientDetails;
import com.spell.model.Purchase;
import com.spell.model.PurchaseDetails;

import java.util.UUID;

public class PurchaseResDto extends Purchase {
    public PurchaseResDto(UUID brandId, ClientDetails client, PurchaseDetails purchase) {
        super(brandId, client, purchase);
    }

    public PurchaseResDto(){
        super(null, new ClientDetails(""), null);
    }
}
