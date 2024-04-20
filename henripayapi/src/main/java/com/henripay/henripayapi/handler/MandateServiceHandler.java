package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.MandateClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import static com.henripay.henripayapi.web.utils.HandlerUtils.throwBpmnError;

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
                var mandateDetails = this.mandateClient.getMandateDetails(mandateId)
                        .blockOptional();
                if (mandateDetails.isEmpty()) {
                    throwBpmnError(execution, "Mandate not found");
                } else {
                    execution.setVariable("mandateDetails", mandateDetails.get());
                }
            } catch (Throwable e) {
                 throwBpmnError(execution, "Error fetching mandate details");
            }
        };
    }
}
