package com.xpay.xpayapi.handler;


import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ActivityAHandler {

    @Bean
    public JavaDelegate activityA() {
        return execution -> {
            log.info("Running Activity A");
            //throw new RuntimeException("I'm supposed to fail.");
            try {
                Thread.sleep(1000);
                log.info("After 5 seconds inside Activity A");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public JavaDelegate rollbackActivityA() {
        return execution -> {
            log.info("Rollback Activity A");
        };
    }

}
