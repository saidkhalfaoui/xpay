package com.henripay.henripayapi.controller;

import com.henripay.henripayapi.service.CommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ActivityProcess {

    private final CommandService commandService;

    public ActivityProcess(CommandService commandService) {
        this.commandService = commandService;
    }

    // start process example
    @PostMapping("/process/start/{key}")
    public String startProcess(@PathVariable String key) {
        return commandService.startProcess(key);
    }
}
