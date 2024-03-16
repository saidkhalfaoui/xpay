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
            log.info("Running Activity B");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            var ex = (String) externalTask.getVariable("ex");
            if (ex.equals("A"))
                service.handleBpmnError(externalTask, "ActivityAError");
            else {
                log.info("After 5 seconds inside Activity B");
                service.complete(externalTask);
            }
        };
    }

    @Bean
    @ExternalTaskSubscription("ActivityB-Rollback")
    public ExternalTaskHandler ActivityBRollback() throws Exception {
        return (externalTask, service) -> {
            log.info("Rollback Activity B");
            Map<String, Object> variables = new HashMap<>();
            variables.put("ActivityB", "C");
            //
            service.complete(externalTask);
        };
    }

}
