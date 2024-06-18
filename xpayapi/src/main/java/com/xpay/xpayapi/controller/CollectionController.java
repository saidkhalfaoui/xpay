package com.xpay.xpayapi.controller;


import com.xpay.xpayapi.dto.Collectioninformation;
import com.xpay.xpayapi.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class CollectionController implements CollectionApiDelegate {

    public final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Override
    public ResponseEntity<Collectioninformation> collectionPost(Collectioninformation collectioninformation) throws IOException {
        String collectionId = collectionService.createCollection(collectioninformation);
        collectioninformation.setCollectionId(collectionId);
        return ResponseEntity.
                ok(collectioninformation);
    }
}

