package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@Component
@Slf4j
public class UserServiceHandler {
    private final UserClient userClient;

    public UserServiceHandler(UserClient userClient){
        this.userClient = userClient;
    }
    @Bean
    public JavaDelegate getUserDetails(){
        return execution -> {
            log.info("Running getUserDetails");
            try {
                Long customerIdIdentifier = (Long) execution.getVariable("customerIdIdentifier");
                execution.setVariable("userDetails",this.userClient.getUserDetails(customerIdIdentifier));
            } catch (RestClientException | IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
