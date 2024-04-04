package com.henripay.henripayapi.handler;


import com.henripay.common.apiClient.ApiClient;
import com.henripay.common.error.ResourceNotFoundException;
import com.henripay.henripayapi.client.MandateClient;
import com.henripay.henripayapi.config.AppUrlsConfig;
import com.henripay.henripayapi.dto.MandateDTO;
import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@Log4j2
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
