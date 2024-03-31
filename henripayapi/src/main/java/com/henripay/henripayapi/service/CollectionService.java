package com.henripay.henripayapi.service;

import com.henripay.henripayapi.client.CustomerClient;
import com.henripay.henripayapi.config.ProcessConstants;
import com.henripay.henripayapi.dto.Collectioninformation;
import com.henripay.henripayapi.dto.UserDTO;
import com.henripay.henripayapi.web.error.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.Variables;
import org.glassfish.jersey.internal.inject.Custom;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Service
public class CollectionService {

    private final CustomerClient customerClient;
    private final RuntimeService runtimeService;

    public CollectionService(CustomerClient customerClient, RuntimeService runtimeService) {
        this.customerClient = customerClient;
        this.runtimeService = runtimeService;
    }

    public String createCollection(Collectioninformation collectioninformation) throws IOException {

        var processDefinitionKey = ProcessConstants.COLLECTION_PROCESS_KEY;

        UserDTO customerDetails = customerClient.getCustomerDetails(collectioninformation.getCustomersId());
        if(customerDetails == null) {
            throw new ResourceNotFoundException("Customer not found");
        }

        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        HashMap<String, Object> vars = new HashMap<>();
        vars.put("collectionInformation", collectioninformation);
        vars.put("mandateId", collectioninformation.getMandateId());
        vars.put("customerId", collectioninformation.getCustomersId());
        vars.put("customerDetails", customerDetails);
        //
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
