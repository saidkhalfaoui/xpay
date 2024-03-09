package com.henripay.henripayapi;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableProcessApplication
@SpringBootApplication
public class HenripayapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HenripayapiApplication.class, args);
    }

}
