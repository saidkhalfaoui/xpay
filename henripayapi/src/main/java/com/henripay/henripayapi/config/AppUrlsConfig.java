package com.henripay.henripayapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "app.urls")
@Data
@Configuration
public class AppUrlsConfig {
    private String userServiceUrl;
    private String mandateServiceUrl;
}