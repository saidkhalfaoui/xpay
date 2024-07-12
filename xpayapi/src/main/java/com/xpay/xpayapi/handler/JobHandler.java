package com.xpay.xpayapi.handler;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobHandler {








        @Bean
        public JavaDelegate handle800jobNotification() {
            return execution -> {
                log.info("Processing CAMS_800_001 file job notification...");
                //throw new RuntimeException("I'm supposed to fail.");
                try {
                    Thread.sleep(1000);
                    log.info("To Do");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
        }
    @Bean
    public JavaDelegate handle520jobNotification() {
        return execution -> {
            log.info("Processing CAMS_520 file job notification...");
            //throw new RuntimeException("I'm supposed to fail.");
            try {
                Thread.sleep(1000);
                log.info("To Do ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
        @Bean
        public JavaDelegate rollbackstartSepaDDjob() {
            return execution -> {
                log.info("Rollback Activity A");
            };
        }

    }


