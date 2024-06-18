package com.xpay.xpayapi.testcontainers;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public interface BaseTestContainer {
    static Network sharedNetwork = Network.newNetwork();

}
