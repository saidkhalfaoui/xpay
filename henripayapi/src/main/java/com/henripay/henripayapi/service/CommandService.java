package com.henripay.henripayapi.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Transactional(rollbackFor = Throwable.class)
@Service
public class CommandService {

    private final RuntimeService runtimeService;

    public CommandService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startProcess(String processDefinitionKey) {
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        HashMap<String, Object> vars = new HashMap<>();
        var processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, uuid.toString(), vars);

        log.info("Process : " + processInstance.getProcessInstanceId() + " ended");
    }
}
