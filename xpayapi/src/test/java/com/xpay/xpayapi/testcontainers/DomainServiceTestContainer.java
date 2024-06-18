package com.xpay.xpayapi.testcontainers;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;



@Testcontainers
@ActiveProfiles("test")
public interface DomainServiceTestContainer extends BaseTestContainer {

    String DOCKER_IMAGE_NAME = "domainservice:0.0.1-SNAPSHOT";
    int PORT = 8080;

    @Container
    GenericContainer<?> container = new GenericContainer<>(DOCKER_IMAGE_NAME)
            .withExposedPorts(5432).withNetwork(sharedNetwork).withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
            new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(5432), new ExposedPort(5432)))
            ));

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("app.ws.domain-service-url",
                () -> String.format("http://localhost:%d", container.getMappedPort(PORT)));
    }
}
