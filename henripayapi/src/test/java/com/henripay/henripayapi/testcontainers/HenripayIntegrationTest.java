package com.henripay.henripayapi.testcontainers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class HenripayIntegrationTest implements PostgresTestContainer,
//        DomainServiceTestContainer,
        CustomerServiceTestContainer
//        SpaDDServiceTestContainer
{

    @BeforeEach
    void check() {
        assertThat(PostgresTestContainer.container.isRunning()).isTrue();
        assertThat(CustomerServiceTestContainer.container.isRunning()).isTrue();
//        assertThat(DomainServiceTestContainer.container.isRunning()).isTrue();
//        assertThat(SpaDDServiceTestContainer.container.isRunning()).isTrue();
    }

    @Test
    void collection_test() {

    }

}
