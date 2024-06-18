package com.xpay.xpayapi.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OtherServiceHandler {

    public OtherServiceHandler(){
    }
    @Bean
    public JavaDelegate doNothing(){
        return execution -> {
            log.info("Running otherServiceHandler: " + execution.getCurrentActivityName());
        };
    }
}
