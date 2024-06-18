package com.xpay.sepadd.service.configuration;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CustomerConfigurations {
    private String cutomerId;
    private String customerName;
}
