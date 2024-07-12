package com.xpay.xpayapi.service;

import com.xpay.common.exception.xpayRequestException;
import com.xpay.xpayapi.client.UserClient;
import com.xpay.xpayapi.config.ProcessConstants;
import com.xpay.xpayapi.dto.Collectioninformation;
import com.xpay.xpayapi.web.error.InvalidInput;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.EventSubscription;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.camunda.bpm.engine.runtime.ProcessInstance;
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

     /*   var userDetails = userServiceClient.getUserDetails(collectioninformation.getCustomerIdIdentifier());
        if (userDetails == null) {
            throw new InvalidInput("User not found");
        }
*/
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        HashMap<String, Object> vars = new HashMap<>();
        vars.put("collectionInformation", collectioninformation);
        vars.put("mandateId", collectioninformation.getMandateId());
        vars.put("customerId", collectioninformation.getCustomerIdIdentifier());
     //   vars.put("customerDetails", userDetails);
        vars.put("customerDetails" , collectioninformation.getCustomerIdIdentifier().toString());
        //
        var processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, uuid.toString(), vars);
        //
        if (processInstance instanceof ProcessInstanceWithVariables) {
            Object bpmnError = ((ProcessInstanceWithVariables) processInstance).getVariables().get("bpmnError");
            if (bpmnError != null && bpmnError.equals("TransactionFailed")) {
                var errorMessage = ((ProcessInstanceWithVariables) processInstance).getVariables().get("bpmnErrorMessage");
                throw new xpayRequestException(String.valueOf(errorMessage));
            }
        }

        log.info("Process  : " + processInstance.getProcessInstanceId() + " synchronous flow ended");

        return processInstance.getId();
    }

    public void catchMessageEvent(String key , String event)
    {
        MessageCorrelationResult result = runtimeService.createMessageCorrelation("sepaddnotification")
                .processInstanceBusinessKey(key)
                .correlateWithResult();
        log.info(result.getExecution().getId());

    }


}
