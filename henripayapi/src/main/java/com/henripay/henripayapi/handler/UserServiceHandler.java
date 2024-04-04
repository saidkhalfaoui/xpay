package com.henripay.henripayapi.handler;

import com.henripay.common.error.ResourceNotFoundException;
import com.henripay.henripayapi.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserServiceHandler {
    private final UserClient userClient;

    public UserServiceHandler(UserClient userClient){
        this.userClient = userClient;
    }

    @Bean
    public JavaDelegate getUserDetails() {
        return execution -> {
            log.info("Running getUserDetails");
            try {
                Long customerId = (Long) execution.getVariable("customerId");
                var userDTO = this.userClient.getUserDetails(customerId)
                        .blockOptional()
                        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
                execution.setVariable("userDetails", userDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
