package com.henripay.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.henripay")
@EnableJpaRepositories("com.henripay.domainservice.repository")
public class CutomerserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CutomerserviceApplication.class, args);
    }

}
