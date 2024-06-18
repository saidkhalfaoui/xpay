package com.xpay.xpayapi.testcontainers;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("test")

public interface CustomerServiceTestContainer {

    static  String DOCKER_IMAGE_NAME = "customerservice-mock:0.0.1-SNAPSHOT";
    static  int PORT = 8080;
    @Container
    static GenericContainer<?> container = new GenericContainer<>(DOCKER_IMAGE_NAME)
            .withExposedPorts(PORT);



    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {

        registry.add("app.ws.user-service-url",
                () ->  String.format("http://localhost:%d/api/v1/", container.getMappedPort(PORT)));


    }


}
