package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.DirectPostRequestDto;
import com.henripay.spellclientservice.service.DirectPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direct-post")
public class DirectPostController {

    private final DirectPostService directPostService;
    Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    @Autowired
    public DirectPostController(DirectPostService directPostService) {
        this.directPostService = directPostService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> directPost(@RequestBody(required = true)DirectPostRequestDto directPostRequestDto) {
        Object res = this.directPostService.doDirectPost(directPostRequestDto);

        return ResponseEntity.ok(res);
    }

}
