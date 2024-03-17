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

    @PostMapping("/process/start/{key}")
    public void startProcess(
            @PathVariable String key
    ) throws ApiException {
        commandService.startProcess(key);
    }

    @PostMapping("/process-2/start/{key}")
    public ResponseEntity<String> startProcess2(
            @PathVariable String key
    ) throws ApiException {
        return commandService.startProcess2(key);
    }

    @PostMapping("/process-mono/start/{key}")
    public Mono<ResponseEntity<String>> startProcessMono(
            @PathVariable String key
    ) throws ApiException {
        return commandService.startProcessMono(key);
    }

    @PostMapping("/process/send-message/{instanceId}/{messageName}")
    public void sendMessage(
            @PathVariable String instanceId,
            @PathVariable String messageName
    ) {
        commandService.sendMessage(messageName, instanceId);
    }
}
