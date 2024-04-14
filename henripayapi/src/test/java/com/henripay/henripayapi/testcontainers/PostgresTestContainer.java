package com.henripay.henripayapi.testcontainers;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
public interface PostgresTestContainer {

    String DOCKER_IMAGE_NAME = "postgres:12";

    @Container
    PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DOCKER_IMAGE_NAME);

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("app.db.url", container::getJdbcUrl);
        registry.add("app.db.username", container::getUsername);
        registry.add("app.db.password", container::getPassword);
    }
}
