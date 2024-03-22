package com.henripay.henripayapi.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiCallback;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.time.Duration.ofSeconds;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CommandService {

    private final ProcessDefinitionApi processDefinitionApi;
    private final ExternalTaskClient externalTaskClient;

    public CommandService(ProcessDefinitionApi processDefinitionApi,
                          ExternalTaskClient externalTaskClient) {
        this.processDefinitionApi = processDefinitionApi;
        this.externalTaskClient = externalTaskClient;
    }

    public ResponseEntity<String> startProcessDirect(String processDefinitionKey) throws ApiException {
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();
        var businessKey = uuid.toString();

        // prepare variables to pass on to process
        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put("businessKey", new VariableValueDto().value(businessKey).type("string"));
        variables.put("ex", new VariableValueDto().value("x").type("string"));

        // start process instance
        var processInstance = processDefinitionApi.startProcessInstanceByKey(
                processDefinitionKey,
                new StartProcessInstanceDto().variables(variables)
        );

        //
        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .body(processInstance.getId())
        ;
    }

    public Mono<Object> startProcess(String processDefinitionKey) throws ApiException {

        UUID uuid = UUID.randomUUID();
        var businessKey = uuid.toString();

        log.info("Process key : " + processDefinitionKey + " started, businessKey: " + businessKey);
        // prepare variables to pass on to process
        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put("businessKey", new VariableValueDto().value(businessKey).type("string"));
        variables.put("ex", new VariableValueDto().value("x").type("string"));

        // start process instance
        var processInstance = processDefinitionApi.startProcessInstanceByKey(
                processDefinitionKey,
                new StartProcessInstanceDto().variables(variables)
        );

        //
        return Mono.create(sink -> {
            var step1End = externalTaskClient
                    .subscribe("Step1-End")
                    // .businessKey(businessKey)
                    .variables("businessKey", businessKey)
                    .lockDuration(5000)
                    .handler((externalTask, service) -> {
                        try {
                            service.complete(externalTask);
                            sink.success(ResponseEntity
                                    .status(HttpStatus.OK)
                                    .body(processInstance.getId())
                            );
                            log.info("Process : " + processInstance.getId() + " ended");
                        } catch (Throwable throwable) {
                            service.handleBpmnError(externalTask, "TransactionFailed");
                        }
                    })

                    .open();
            sink.onDispose(step1End::close);
        }).timeout(ofSeconds(1000), Mono.just(ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .body("Request timeout")
        ));
    }

    public Mono<Object> startProcessCallback(String processDefinitionKey) {
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();
        var businessKey = uuid.toString();

        // prepare variables to pass on to process
        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put("businessKey", new VariableValueDto().value(businessKey).type("string"));
        variables.put("ex", new VariableValueDto().value("x").type("string"));
        return Mono.create(sink -> {
            // start process instance
            try {
                processDefinitionApi.startProcessInstanceByKeyAsync(
                        processDefinitionKey,
                        new StartProcessInstanceDto().variables(variables),
                        new ApiCallback<>() {
                            @Override
                            public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                                log.error("Error starting process instance", e);
                            }

                            @Override
                            public void onSuccess(ProcessInstanceWithVariablesDto result, int statusCode, Map<String, List<String>> responseHeaders) {
                                log.info("Process instance started: {}", result.getId());
                            }

                            @Override
                            public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                                log.info("Uploading process instance");
                            }

                            @Override
                            public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                                log.info("Downloading process instance");
                            }
                        }
                );
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
