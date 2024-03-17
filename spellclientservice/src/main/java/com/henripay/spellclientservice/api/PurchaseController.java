package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.ClientDto;
import com.henripay.spellclientservice.api.model.ProductDto;
import com.henripay.spellclientservice.api.model.PurchaseDto;
import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.service.PurchaseService;
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

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    Logger logger = LoggerFactory.getLogger(PurchaseController.class);


    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> purchasePost(@RequestBody(required = true) PurchaseRequestDto purchaseRequestDto) {
        Object res = this.purchaseService.doPurchase(purchaseRequestDto);
        return ResponseEntity.ok(res);
    }

}
