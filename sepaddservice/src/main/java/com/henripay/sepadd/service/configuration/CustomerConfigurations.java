package com.henripay.sepadd.service.configuration;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yaml")
@Getter
public class CustomerConfigurations {
    private String cutomerId;
    private String customerName;
}