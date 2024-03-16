package com.henripay.henripayapi.handler.activityc;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityC {

    @Bean
    @ExternalTaskSubscription("ActivityC-Run")
    public ExternalTaskHandler ActivityCRun() throws Exception {
        return (externalTask, service) -> {
            log.info("Running Activity C");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            var ex = (String)externalTask.getVariable("ex");
            if(ex.equals("A"))
                service.handleBpmnError(externalTask, "ActivityAError");
            else {
                log.info("After 5 seconds inside Activity C");
                service.complete(externalTask);
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
