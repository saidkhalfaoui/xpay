package com.xpay.xpayapi.testcontainers;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")
public interface SpaDDServiceTestContainer {

    String DOCKER_IMAGE_NAME = "sepaddservice-mock:0.0.1-SNAPSHOT";
    int PORT = 8080;

    @Container
    GenericContainer<?> container = new GenericContainer<>(DOCKER_IMAGE_NAME)
            .withExposedPorts(PORT);

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("app.ws.sepadd-service-url",
                () -> String.format("http://localhost:%d/api/v1/", container.getMappedPort(PORT)));
    }
}
