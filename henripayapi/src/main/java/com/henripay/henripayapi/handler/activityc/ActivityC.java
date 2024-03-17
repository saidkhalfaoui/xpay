package com.henripay.henripayapi.handler.activityc;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ActivityC {

    @Bean
    @ExternalTaskSubscription("ActivityC-Run")
    public ExternalTaskHandler ActivityCRun() throws Exception {
        return (externalTask, service) -> {
            Map<String, Object> variables = new HashMap<>();
            try {
                log.info("Running Activity C");
                var ex = (String) externalTask.getVariable("ex");
                if (ex.equals("C")) {
                    log.info("Error in Activity C!");
                    throw new RuntimeException();
                } else {
                    Thread.sleep(1000);
                    log.info("After 1 second inside Activity C");
                    service.complete(externalTask, variables);
                }
            } catch (Throwable throwable) {
                service.handleBpmnError(externalTask, "TransactionFailed", "", variables);
            }
        };
    }

    @Bean
    @ExternalTaskSubscription("ActivityC-Rollback")
    public ExternalTaskHandler ActivityCRollback() throws Exception {
        return (externalTask, service) -> {
            log.info("Rollback Activity C");

            service.complete(externalTask);
        };
    }

}
