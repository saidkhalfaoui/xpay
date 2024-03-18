package com.henripay.spellclientservice.api;

import com.henripay.spellclientservice.api.model.DirectPostRequestDto;
import com.henripay.spellclientservice.service.DirectPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class DirectPostController {

    private final DirectPostService directPostService;

    @Autowired
    public DirectPostController(DirectPostService directPostService) {
        this.directPostService = directPostService;
    }


    @PostMapping(
            value = "/direct-post"
    )
    public ResponseEntity<Object> directPost(@RequestBody(required = true) DirectPostRequestDto directPostRequestDto) {
        Object res = this.directPostService.doDirectPost(directPostRequestDto);

        return ResponseEntity.ok(res);
    }

}
