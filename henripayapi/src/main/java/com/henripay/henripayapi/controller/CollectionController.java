package com.henripay.henripayapi.controller;


import com.henripay.henripayapi.api.CollectionApi;
import com.henripay.henripayapi.model.Collectioninformation;
import com.henripay.henripayapi.service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CollectionController implements CollectionApi {

    public final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @Override
    public ResponseEntity<List<String>> collectionPost(Collectioninformation collectioninformation) {

        log.info("Collection information : " + collectioninformation.toString());
        String collectionId = collectionService.createCollection(collectioninformation);
        return ResponseEntity.ok(List.of(collectionId));
    }
}

