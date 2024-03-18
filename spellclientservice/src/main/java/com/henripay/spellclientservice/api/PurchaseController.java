package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.ClientDto;
import com.henripay.spellclientservice.api.model.ProductDto;
import com.henripay.spellclientservice.api.model.PurchaseDto;
import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;

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
    public ResponseEntity<Object> purchasePost(@RequestBody(required = true) PurchaseRequestDto purchaseRequestDto) {
        Object res = this.purchaseService.doPurchase(purchaseRequestDto);
        return ResponseEntity.ok(res);
    }

}
