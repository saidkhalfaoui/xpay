package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.ChargePurchaseDto;
import com.henripay.spellclientservice.service.ChargePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ChargeController {
    private final ChargePurchaseService chargePurchaseService;

    @Autowired
    public ChargeController(ChargePurchaseService chargePurchaseService) {
        this.chargePurchaseService = chargePurchaseService;
    }

    @PostMapping(value = "/charge")
    public ResponseEntity<Object> charge(
            @RequestBody ChargePurchaseDto chargePurchaseDto,
            @RequestParam(name = "purchaseId") String purchaseId
            ) throws IOException {
        Object res = this.chargePurchaseService.doChargePurchase(purchaseId, chargePurchaseDto);
        return ResponseEntity.ok(res);
    }
}
