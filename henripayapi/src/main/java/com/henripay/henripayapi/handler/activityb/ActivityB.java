package com.henripay.henripayapi.handler.activityb;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityB {

    @Bean
    @ExternalTaskSubscription("ActivityB-Run")
    public ExternalTaskHandler ActivityBRun() throws Exception {
        return (externalTask, service) -> {
            Map<String, Object> variables = new HashMap<>();
            try {
                log.info("Running Activity B");
                var ex = (String) externalTask.getVariable("ex");
                if (ex.equals("B")) {
                    log.info("Error in Activity B!");
                    throw new RuntimeException();
                } else {
                    Thread.sleep(1000);
                    log.info("After 1 second inside Activity B");
                    variables.put("ActivityB", "C");
                    service.complete(externalTask, variables);
                }
            } catch (Throwable throwable) {
                variables.put("ActivityB", "F");
                service.handleBpmnError(externalTask, "TransactionFailed", "", variables);
            }
        };
    }

    @Bean
    @ExternalTaskSubscription("ActivityB-Rollback")
    public ExternalTaskHandler ActivityBRollback() throws Exception {
        return (externalTask, service) -> {
            log.info("Rollback Activity B");
            service.complete(externalTask);
        };
    }

}
