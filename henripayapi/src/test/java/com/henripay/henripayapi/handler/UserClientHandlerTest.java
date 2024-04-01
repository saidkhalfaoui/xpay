package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.client.UserClient;
import com.henripay.henripayapi.dto.UserDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserClientHandlerTest {

    @Mock
    private UserClient userClient;

    @Mock
    private DelegateExecution execution;

    private UserServiceHandler handler;

    @BeforeEach
    void setUp() {
        handler = new UserServiceHandler(userClient);
    }

    @Test
    void testGetUserDetails() throws Exception {
        // Arrange
        Long customerId = 123L;
        Map<String, Object> variables = new HashMap<>();

        UserDTO expectedUser = new UserDTO();
        expectedUser.setCustomerIdIdentifier(customerId);
        expectedUser.setFullName("John Doe");
        expectedUser.setIban("CH93 0076 2011 6238 5295 7");

        variables.put("customerId", customerId);
        when(execution.getVariable("customerId")).thenReturn(customerId);
        when(userClient.getUserDetails(anyLong())).thenReturn(expectedUser);

        // Act
        handler.getUserDetails().execute(execution);


        // Assert
        verify(userClient, times(1)).getUserDetails(customerId);
        verify(execution, times(1)).setVariable("userDetails",expectedUser);
    }

    @Test
    void testGetUserDetailsWithException() throws IOException {
        // Arrange
        Long customerId = 123L;
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerId", customerId);
        when(execution.getVariable("customerId")).thenReturn(customerId);
        when(userClient.getUserDetails(customerId)).thenThrow(new IOException());

        // Act & Assert
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> handler.getUserDetails().execute(execution));
    }
}
