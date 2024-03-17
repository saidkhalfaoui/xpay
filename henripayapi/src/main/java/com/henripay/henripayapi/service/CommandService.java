package com.henripay.henripayapi.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.api.ProcessInstanceApi;
import org.camunda.community.rest.client.dto.ProcessInstanceDto;
import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.camunda.community.rest.client.springboot.CamundaHistoryApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CommandService {

    private final ProcessDefinitionApi processDefinitionApi;
    private final ProcessInstanceApi processInstanceApi;

    private final CamundaHistoryApi camundaHistoryApi;

    public CommandService(ProcessDefinitionApi processDefinitionApi, ProcessInstanceApi processInstanceApi, CamundaHistoryApi camundaHistoryApi) {
        this.processDefinitionApi = processDefinitionApi;
        this.processInstanceApi = processInstanceApi;
        this.camundaHistoryApi = camundaHistoryApi;

    }

    public ResponseEntity<String> startProcess(String processDefinitionKey) throws ApiException {
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();
        HashMap<String, Object> vars = new HashMap<>();

        // prepare variables to pass on to process
        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put("ex", new VariableValueDto().value("x").type("string"));

        // start process instance
        var processInstance = processDefinitionApi.startProcessInstanceByKey(
                processDefinitionKey,
                new StartProcessInstanceDto().variables(variables)
        );
        //

        VariableValueDto step1 = null;
        while (step1 == null || !(Objects.equals(step1.getValue(), "C") || Objects.equals(step1.getValue(), "F"))) {
            try {
                Thread.sleep(1000);
                //var ps = processInstanceApi.getProcessInstance(processInstance.getId());
                step1 = processInstanceApi.getProcessInstanceVariable(processInstance.getId(), "Step1", false);
            } catch (Throwable e) {

            }
        }

        log.info("Process : " + processInstance.getId() + " ended");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Started process instance with id: " + processInstance.getId());

    }

    public void sendMessage(String instanceId, String messageName) {

        UUID uuid = UUID.randomUUID();
        HashMap<String, Object> vars = new HashMap<>();

//        runtimeService.messageEventReceived(messageName, instanceId);
    }

}
