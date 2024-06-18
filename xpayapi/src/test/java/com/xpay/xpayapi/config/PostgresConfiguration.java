package com.xpay.xpayapi.config;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
public  class PostgresConfiguration {


    @Bean
    @ServiceConnection


    public PostgreSQLContainer<?> postgresContainer( ){
        return new PostgreSQLContainer<>("postgres:16.0-alpine")

                .withReuse(true);
    }
}