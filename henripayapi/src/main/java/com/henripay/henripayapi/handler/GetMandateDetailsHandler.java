package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.service.MandateService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@Component
@Slf4j
public class GetMandateDetailsHandler {

    private final MandateService mandateService;

    public GetMandateDetailsHandler(MandateService mandateService) {
        this.mandateService = mandateService;

    }

    @Bean
    public JavaDelegate getMandateDetails() {
        return execution -> {
            log.info("Running getMandateDetails");
            try {
                Integer mandateId = (Integer) execution.getVariable("mandateId");
                execution.setVariable("mandateDetails", this.mandateService.getMandateDetails(mandateId));
            } catch (RestClientException | IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
