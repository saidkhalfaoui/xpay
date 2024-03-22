package com.henripay.henripayapi.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityBHandler {

    @Bean
    public JavaDelegate activityB() {
        return execution -> {
            log.info("Running Activity B");
            //throw new RuntimeException("I'm supposed to fail.");
            try {
                Thread.sleep(5000);
                log.info("After 5 seconds inside Activity B");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public JavaDelegate rollbackActivityB() {
        return execution -> {
            log.info("Rollback Activity B");
        };
    }

}
