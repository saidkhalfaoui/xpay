package com.xpay.xpayapi.testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.storage.HttpMethod;
import com.xpay.xpayapi.dto.Collectioninformation;
import com.xpay.xpayapi.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

import org.testcontainers.containers.PostgreSQLContainer;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.api.model.HostConfig;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.containers.Network;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(OutputCaptureExtension.class)
@Testcontainers

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Slf4j
class xpayIntegrationTest implements
  // DomainServiceTestContainer,
        BaseTestContainer,
        CustomerServiceTestContainer,
        SpaDDServiceTestContainer ,
        MandateServiceTestContainer

{


    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0-alpine");


    @Autowired
    TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;




    // Configure containers to use the shared network







    @Test
    void connectionEstablished() {
       assertThat(postgres.isCreated()).isTrue();
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    void contextLoads() {
    }
    @BeforeEach
    void CheckDatabase() {
        try (Connection connection = DriverManager.getConnection(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword())) {
            assertThat(connection).isNotNull();
            assertThat(connection.isValid(5)).isTrue(); // Check connection validity
            log.info("Database is ok");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }


    @BeforeEach
    void CheckTestContainers() {






    }



        @BeforeEach
    void check() {




        /*if (!DomainServiceTestContainer.container.isRunning())
        {
            DomainServiceTestContainer.container.start();
        }*/
        if (!CustomerServiceTestContainer.container.isRunning()) {
          CustomerServiceTestContainer.container.start();
        }
       // assertThat(CustomerServiceTestContainer.container.isRunning()).isTrue();

//        assertThat(DomainServiceTestContainer.container.isRunning()).isTrue();
//        assertThat(SpaDDServiceTestContainer.container.isRunning()).isTrue();
    }

    @Test
    void collection_test() {
        if (CustomerServiceTestContainer.container.isRunning())
            log.info("dependent container is running");
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/collection.json");
        Collectioninformation collectionInformation = null;
        try {
            collectionInformation = objectMapper.readValue(jsonFile, Collectioninformation.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       String  url = "http://localhost:" + port + "/api/v1/collection/";
        ResponseEntity<?> response = restTemplate.exchange(
                url,
                POST,
                new HttpEntity<>(collectionInformation),
                new ParameterizedTypeReference<Object>() {}
        );

        assertThat(response.getStatusCode().equals(HttpStatusCode.valueOf(200)) ).isTrue();


    }



}
