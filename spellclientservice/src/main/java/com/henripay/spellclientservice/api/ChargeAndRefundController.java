package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.ChargePurchaseDto;
import com.henripay.spellclientservice.api.model.RefundPurchaseDto;
import com.henripay.spellclientservice.service.ChargePurchaseService;
import com.henripay.spellclientservice.service.RefundPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ChargeAndRefundController {
    private final ChargePurchaseService chargePurchaseService;
    private final RefundPurchaseService refundPurchaseService;

    @Autowired
    public ChargeAndRefundController(ChargePurchaseService chargePurchaseService, RefundPurchaseService refundPurchaseService) {
        this.chargePurchaseService = chargePurchaseService;
        this.refundPurchaseService = refundPurchaseService;
    }

    @PostMapping(value = "/charge")
    public ResponseEntity<Object> charge(
            @RequestBody ChargePurchaseDto chargePurchaseDto,
            @RequestParam(name = "purchaseId") String purchaseId
            ) throws IOException {
        Object res = this.chargePurchaseService.doChargePurchase(purchaseId, chargePurchaseDto);
        return ResponseEntity.ok(res);
    }

    @PostMapping(value = "/refund")
    public ResponseEntity<Object> refund(
            @RequestBody RefundPurchaseDto refundPurchaseDto,
            @RequestParam(name = "purchaseId") String purchaseId
            ) throws IOException {
        Object res = this.refundPurchaseService.doRefundPurchase(purchaseId, refundPurchaseDto);
        return ResponseEntity.ok(res);
    }
}
