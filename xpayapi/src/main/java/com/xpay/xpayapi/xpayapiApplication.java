package com.xpay.xpayapi;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableProcessApplication
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = "com.xpay")
public class xpayapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(xpayapiApplication.class, args);
    }

}
