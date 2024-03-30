package com.henripay.henripayapi.service;

import com.henripay.henripayapi.config.ProcessConstants;
import com.henripay.henripayapi.model.Collectioninformation;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Service
public class CollectionService {

    private final RuntimeService runtimeService;

    public CollectionService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String createCollection(Collectioninformation collectioninformation) {

         var processDefinitionKey = ProcessConstants.COLLECTION_PROCESS_KEY;

        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        HashMap<String, Object> vars = new HashMap<>();
        vars.put("collectionInformation", collectioninformation);
        vars.put("mandateId", collectioninformation.getMandateId());
        var processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, uuid.toString(), vars);
        //
        if (processInstance instanceof ProcessInstanceWithVariables) {
            Object bpmnError = ((ProcessInstanceWithVariables) processInstance).getVariables().get("bpmnError");
            if (bpmnError != null && bpmnError.equals("TransactionFailed")) {
                //throw new RuntimeException("Process error");
            }
        }

        log.info("Process : " + processInstance.getProcessInstanceId() + " ended");

        return processInstance.getId();
    }
}
