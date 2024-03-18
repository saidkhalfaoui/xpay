package com.henripay.mandateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.henripay")
@EnableJpaRepositories("com.henripay.domainservice.repository")
public class MandateserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MandateserviceApplication.class, args);
    }

}
