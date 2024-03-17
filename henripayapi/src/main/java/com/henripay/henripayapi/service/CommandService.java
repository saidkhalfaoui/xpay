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
    private final ExternalTaskClient externalTaskClient;

    public CommandService(ProcessDefinitionApi processDefinitionApi,
                          ExternalTaskClient externalTaskClient) {
        this.processDefinitionApi = processDefinitionApi;
        this.externalTaskClient = externalTaskClient;
    }

    public Mono<ResponseEntity<String>> startProcess(String processDefinitionKey) throws ApiException {
        log.info("Process : " + processDefinitionKey + " started");

        UUID uuid = UUID.randomUUID();

        // prepare variables to pass on to process
        Map<String, VariableValueDto> variables = new HashMap<>();
        variables.put("ex", new VariableValueDto().value("x").type("string"));

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

}
