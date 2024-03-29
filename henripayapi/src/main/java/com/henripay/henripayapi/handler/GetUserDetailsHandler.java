package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@Component
@Slf4j
public class GetUserDetailsHandler {
    private final UserService userService;

    public GetUserDetailsHandler(UserService userService){
        this.userService = userService;
    }
    @Bean
    public JavaDelegate getUserDetails(){
        return execution -> {
            log.info("Running getUserDetails");
            try {
                Integer customerId = (Integer) execution.getVariable("customerId");
                execution.setVariable("userDetails",this.userService.getUserDetails(customerId));
            } catch (RestClientException | IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
