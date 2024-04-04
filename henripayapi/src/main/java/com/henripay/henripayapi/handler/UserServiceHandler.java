package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.UserClient;
import com.henripay.henripayapi.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Log4j2
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
                Long customerId = (Long) execution.getVariable("customerId");
                Mono<UserDTO> response = this.userClient.getUserDetails(customerId);
                response.subscribe(userDTO -> {
                    execution.setVariable("userDetails", userDTO);
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
