package com.henripay.henripayapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.urls")
public class AppUrlsConfig {
    private String userServiceUrl;
    private String mandateServiceUrl;
}
