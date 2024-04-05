package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.UserClient;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.henripay.henripayapi.web.utils.HandlerUtils.throwBpmnError;

@Component
@Log4j2
public class UserServiceHandler {
    private final UserClient userServiceClient;

    public UserServiceHandler(UserClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Bean
    public JavaDelegate getUserDetails() {
        return (DelegateExecution execution) -> {
            log.info("Running getUserDetails");
            try {
                Long customerId = (Long) execution.getVariable("customerId");
                var userDTO = this.userServiceClient.getUserDetails(customerId)
                        .blockOptional();
                if (userDTO.isEmpty())
                    throwBpmnError(execution, "User not found");
                else {
                    execution.setVariable("userDetails", userDTO.get());
                }
            } catch (Throwable e) {
                throwBpmnError(execution, "Error fetching user details" + e.getMessage());
            }
        };
    }
}
