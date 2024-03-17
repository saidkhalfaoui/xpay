package com.henripay.henripayapi.handler.activitya;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityA {

    @Bean
    @ExternalTaskSubscription("ActivityA-Run")
    public ExternalTaskHandler ActivityARun() throws Exception {
        return (externalTask, service) -> {
            Map<String, Object> variables = new HashMap<>();
            try {
                log.info("Running Activity A");
                var ex = (String) externalTask.getVariable("ex");
                if (ex.equals("A")) {
                    log.info("Error in Activity A!");
                    throw new RuntimeException();
                } else {
                    Thread.sleep(1000);
                    log.info("After 1 second inside Activity A");
                    variables.put("ActivityA", "C");
                    service.complete(externalTask, variables);
                }
            } catch (Throwable throwable) {
                variables.put("ActivityA", "F");
                service.handleBpmnError(externalTask, "TransactionFailed", "", variables);
            }
        };
    }

    @Bean
    @ExternalTaskSubscription("ActivityA-Rollback")
    public ExternalTaskHandler ActivityARollback() throws Exception {
        return (externalTask, service) -> {
            log.info("Rollback Activity A");
            service.complete(externalTask);
        };
    }

}
