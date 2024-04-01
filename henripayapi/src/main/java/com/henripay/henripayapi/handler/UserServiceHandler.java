package com.henripay.henripayapi.handler;

import com.henripay.common.apiClient.ApiClient;
import com.henripay.henripayapi.client.UserClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import com.henripay.henripayapi.dto.UserDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class UserServiceHandler {
    private final UserClient userClient;

    public UserServiceHandler(AppUrlsConfig appUrlsConfig){
        this.userClient = ApiClient.getApiService(appUrlsConfig.getUserServiceUrl(), UserClient.class);
    }
    @Bean
    public JavaDelegate getUserDetails(){
        return execution -> {
            log.info("Running getUserDetails");
            try {
                Integer customerId = (Integer) execution.getVariable("customerId");
                Mono<UserDetailsDto> response = this.userClient.getUserDetails(customerId);
                response.subscribe(userDetailsDto -> {
                    execution.setVariable("userDetails", userDetailsDto);
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
