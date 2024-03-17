package com.henripay.henripayapi.config;

import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalTaskClientFactory {

    @Value("${camunda.bpm.client.base-url}")
    private String baseUrl;
    @Bean
    public ExternalTaskClient externalTaskClient() {
        return ExternalTaskClient.create()
                .baseUrl(baseUrl)
                .asyncResponseTimeout(10000)
                .build();
    }
}
