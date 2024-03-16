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
            log.info("Running Activity A");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            var ex = (String) externalTask.getVariable("ex");
            if (ex.equals("A")) {
                log.info("Error in Activity A!");
                //int retries = externalTask.getRetries();
                //long retryTimeout = 2000L;
                //service.handleFailure(externalTask, "error", "Error details", 0, retryTimeout);
                //
                //service.handleBpmnError(externalTask, "TransactionFailed");
                //service.handleFailure(externalTask, "transactionFailed", "Error details", 0, 1000L);
                //throw new RuntimeException("recipient-not-found");

            } else {
                log.info("After 5 seconds inside Activity A");
                Map<String, Object> variables = new HashMap<>();
                variables.put("ActivityA", "C");
                service.complete(externalTask, variables);
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
