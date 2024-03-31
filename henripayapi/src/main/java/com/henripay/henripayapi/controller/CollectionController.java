package com.henripay.henripayapi.controller;


import com.henripay.henripayapi.dto.Collectioninformation;
import com.henripay.henripayapi.service.CollectionService;
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
    public ResponseEntity<List<String>> collectionPost(Collectioninformation collectioninformation) throws IOException {
        String collectionId = collectionService.createCollection(collectioninformation);
        return ResponseEntity.
                ok(List.of(collectionId));
    }
}

