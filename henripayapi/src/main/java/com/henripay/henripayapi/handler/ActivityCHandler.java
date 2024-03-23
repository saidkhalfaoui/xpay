package com.henripay.henripayapi.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityCHandler {

    @Bean
    public JavaDelegate activityC() {
        return execution -> {
            log.info("Running Activity C");
            //throw new RuntimeException("I'm supposed to fail.");
            try {
                Thread.sleep(1000);
                log.info("After 5 seconds inside Activity C");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public JavaDelegate rollbackActivityC() {
        return execution -> {
            log.info("Rollback Activity C");
        };
    }

}
