package com.henripay.henripayapi.controller;

import com.henripay.henripayapi.service.CommandService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ActivityProcess {


    private final CommandService commandService;

    public ActivityProcess(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/process-direct/start/{key}")
    public ResponseEntity<String> startProcessDisrect(
            @PathVariable String key
    ) throws ApiException {
        return commandService.startProcessDirect(key);
    }

    @PostMapping("/process/start/{key}")
    public Mono<Object> startProcessMono(
            @PathVariable String key
    ) throws ApiException {
        return commandService.startProcess(key);
    }

    @PostMapping("/process-callback/start/{key}")
    public Mono<Object> startProcessCallback(
            @PathVariable String key
    ) throws ApiException {
        return commandService.startProcessCallback(key);
    }

}
