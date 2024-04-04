package com.henripay.henripayapi.handler;


import com.henripay.common.error.ResourceNotFoundException;
import com.henripay.henripayapi.client.MandateClient;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


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
                        .blockOptional()
                        .orElseThrow(() -> new ResourceNotFoundException("Mandate not found"));
                execution.setVariable("mandateDetails", mandateDetails);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
