package com.xpay.xpayapi.handler;

import com.xpay.xpayapi.client.MandateClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.xpay.xpayapi.web.utils.HandlerUtils.throwBpmnError;

@Component
@Slf4j
public class MandateServiceHandler {

    private final MandateClient mandateClient;

    public MandateServiceHandler(MandateClient mandateClient) {
        this.mandateClient = mandateClient;
    }

    @Bean
    public JavaDelegate getMandateDetails() {
        return execution -> {
            log.info("Running getMandateDetails");
            try {
                Long mandateId = (Long) execution.getVariable("mandateId");
                var mandateDetails = this.mandateClient.getMandateDetails(mandateId);
                if (mandateDetails == null) {
                    throwBpmnError(execution, "Mandate not found");
                } else {
                    execution.setVariable("mandateDetails", mandateDetails);
                }
            } catch (Throwable e) {
                 throwBpmnError(execution, "Error fetching mandate details");
            }
        };
    }
}
