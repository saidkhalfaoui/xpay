package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(
            value = "/purchase"
    )
    public ResponseEntity<Object> purchasePost(@RequestBody(required = true) PurchaseRequestDto purchaseRequestDto) throws IOException {
        Object res = this.purchaseService.doPurchase(purchaseRequestDto);
        return ResponseEntity.ok(res);
    }

}
