package com.henripay.henripayapi.handler;

import com.henripay.common.apiClient.ApiClient;
import com.henripay.common.error.ResourceNotFoundException;
import com.henripay.henripayapi.client.UserClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserServiceHandler {
    private final UserClient userClient;

    public UserServiceHandler(AppUrlsConfig appUrlsConfig) {
        this.userClient = ApiClient.getApiService(appUrlsConfig.getUserServiceUrl(), UserClient.class);
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
