package com.henripay.henripayapi.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CommandService {

    private final RuntimeService runtimeService;

    public CommandService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startProcess(String processDefinitionKey) {
        log.info("Process : " + processDefinitionKey + " started");

        HashMap<String, Object> vars = new HashMap<>();
        runtimeService.startProcessInstanceByKey(processDefinitionKey, vars);

        log.info("Process : " + processDefinitionKey + " ended");
    }
}
