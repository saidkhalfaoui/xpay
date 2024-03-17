package com.henripay.henripayapi.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.topic.TopicSubscription;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.api.ProcessInstanceApi;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.camunda.community.rest.client.springboot.CamundaHistoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
public class CommandService {

    private final ProcessDefinitionApi processDefinitionApi;
    private final ProcessInstanceApi processInstanceApi;
    private final ExternalTaskClient externalTaskClient;

    private final CamundaHistoryApi camundaHistoryApi;

    public CommandService(ProcessDefinitionApi processDefinitionApi, ProcessInstanceApi processInstanceApi, ExternalTaskClient externalTaskClient, CamundaHistoryApi camundaHistoryApi) {
        this.processDefinitionApi = processDefinitionApi;
        this.processInstanceApi = processInstanceApi;
        this.externalTaskClient = externalTaskClient;
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
                step1 = processInstanceApi.getProcessInstanceVariable(processInstance.getId(), "Step1", false);
            } catch (Throwable ignored) {

            }
        }

        log.info("Process : " + processInstance.getId() + " ended");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Started process instance with id: " + processInstance.getId());

    }

    public ResponseEntity<String> startProcess2(String processDefinitionKey) throws ApiException {
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

        CompletableFuture<Boolean> futureStep1 = new CompletableFuture<>();

        Runnable fetchStep1 = () -> {
            int retries = 20;
            while (!futureStep1.isDone()) {
                try {
                    Thread.sleep(500);
                    if (extracted(processInstance.getId())) {
                        futureStep1.complete(true);
                        break;
                    }
                    retries--;
                } catch (Throwable ignored) {
                }
                //
                if (retries < 0) {
                    log.error("Failed to retrieve Step1 variable after retries. Exiting.");
                    futureStep1.completeExceptionally(new RuntimeException("Step1 retrieval timed out"));
                    break;
                }
            }
        };

        new Thread(fetchStep1).start();

        Boolean step1;
        try {
            step1 = futureStep1.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error("Error waiting for Step1 variable: " + e.getMessage(), e);
            throw new ApiException("Failed to retrieve Step1 variable");
        }

        log.info("Process : " + processInstance.getId() + " ended");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Started process instance with id: " + processInstance.getId());
    }

    private boolean extracted(String processInstance) throws ApiException {
        var step1 = processInstanceApi.getProcessInstanceVariable(processInstance, "Step1", false);
        if (step1 != null && (Objects.equals(step1.getValue(), "C") || Objects.equals(step1.getValue(), "F"))) {
            return true;
        }
        return false;
    }

    public Mono<ResponseEntity<String>> startProcessMono(String processDefinitionKey) throws ApiException {
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        // prepare variables to pass on to process
        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put("ex", new VariableValueDto().value("x").type("string"));
        variables.put("Step1", new VariableValueDto().value("x").type("string"));

        // start process instance
        var processInstance = processDefinitionApi.startProcessInstanceByKey(
                processDefinitionKey,
                new StartProcessInstanceDto().variables(variables)
        );
        //
        return Mono.create(sink -> {
            TopicSubscription step1End = externalTaskClient.subscribe("Step1-End")
                    .lockDuration(10000)
                    .handler((externalTask, service) -> {
                        try {
                            service.complete(externalTask);
                            sink.success(ResponseEntity
                                    .status(HttpStatus.OK)
                                    .body(processInstance.getId())
                            );
                        } catch (Throwable throwable) {
                            service.handleBpmnError(externalTask, "TransactionFailed");
                        }
                    })
                    .open();
            sink.onDispose(step1End::close);
            log.info("Process : " + processInstance.getId() + " ended");
        });
    }

    private void pollProcessInstanceStatus(String processInstanceId, MonoSink<ResponseEntity<String>> sink) {
        boolean completed = false;
        int retries = 10;
        while (!completed) {
            log.info("Time:" + System.currentTimeMillis());
            retries--;
            try {
                if (extracted(processInstanceId)) {
                    completed = true;
                    sink.success(ResponseEntity
                            .status(HttpStatus.OK)
                            .body("Started process instance with id: " + processInstanceId)
                    );
                } else {
                    Mono.delay(ofMillis(500))
                            .subscribe(ignore -> {
                            });
                }
            } catch (ApiException ignored) {
            }
            if (retries < 0) {
                sink.success(ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error fetching process instance: Timeout")
                );
                completed = true;
            }
        }
    }

    public void sendMessage(String instanceId, String messageName) {

        UUID uuid = UUID.randomUUID();
        HashMap<String, Object> vars = new HashMap<>();

//        runtimeService.messageEventReceived(messageName, instanceId);
    }

}
