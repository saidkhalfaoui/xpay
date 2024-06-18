package com.xpay.xpayapi.handler;

import com.xpay.xpayapi.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.xpay.xpayapi.web.utils.HandlerUtils.throwBpmnError;

@Component
@Slf4j
public class UserServiceHandler {

    private final UserClient userClient;

    public UserServiceHandler(UserClient userClient){
        this.userClient = userClient;
    }

    @Bean
    public JavaDelegate getUserDetails() {
        return (DelegateExecution execution) -> {
            log.info("Running getUserDetails") ;
            try {
                Long customerId = (Long) execution.getVariable("customerId");

                var userDTO = this.userClient.getUserDetails(customerId);
                if (userDTO == null)
                    throwBpmnError(execution, "User not found");
                else {
                    execution.setVariable("userDetails", userDTO);
                }
            } catch (Throwable e) {
                throwBpmnError(execution, "Error fetching user details" + e.getMessage());
            }
        };
    }
}
