package com.henripay.henripayapi.service;

import com.henripay.common.exception.HenripayRequestException;
import com.henripay.henripayapi.client.UserClient;
import com.henripay.henripayapi.config.ProcessConstants;
import com.henripay.henripayapi.dto.Collectioninformation;
import com.henripay.henripayapi.web.error.InvalidInput;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Service
public class CollectionService {

    private final UserClient userServiceClient;
    private final RuntimeService runtimeService;

    public CollectionService(RuntimeService runtimeService, UserClient userServiceClient) {
        this.runtimeService = runtimeService;
        this.userServiceClient = userServiceClient;
    }

    public String createCollection(Collectioninformation collectioninformation) {

        var processDefinitionKey = ProcessConstants.COLLECTION_PROCESS_KEY;

        var userDetails = userServiceClient.getUserDetails(collectioninformation.getCustomerIdIdentifier());
        if (userDetails == null) {
            throw new InvalidInput("User not found");
        }

        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        HashMap<String, Object> vars = new HashMap<>();
        vars.put("collectionInformation", collectioninformation);
        vars.put("mandateId", collectioninformation.getMandateId());
        vars.put("customerId", collectioninformation.getCustomerIdIdentifier());
        vars.put("customerDetails", userDetails);
        //
        var processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, uuid.toString(), vars);
        //
        if (processInstance instanceof ProcessInstanceWithVariables) {
            Object bpmnError = ((ProcessInstanceWithVariables) processInstance).getVariables().get("bpmnError");
            if (bpmnError != null && bpmnError.equals("TransactionFailed")) {
                var errorMessage = ((ProcessInstanceWithVariables) processInstance).getVariables().get("bpmnErrorMessage");
                throw new HenripayRequestException(String.valueOf(errorMessage));
            }
        }

        log.info("Process : " + processInstance.getProcessInstanceId() + " ended");

        return processInstance.getId();
    }
}