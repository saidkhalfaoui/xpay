package com.henripay.henripayapi.handler;

import com.henripay.henripayapi.service.UserService;
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
class GetUserDetailsHandlerTest {

    @Mock
    private UserService userService;

    @Mock
    private DelegateExecution execution;

    private GetUserDetailsHandler handler;

    @BeforeEach
    void setUp() {
        handler = new GetUserDetailsHandler(userService);
    }

    @Test
    void testGetUserDetails() throws Exception {
        // Arrange
        int customerId = 123;
        Map<String, Object> variables = new HashMap<>();

        Map<String, Object> expectedUser = new HashMap<>();
        expectedUser.put("id", customerId);
        expectedUser.put("name", "John Doe");
        expectedUser.put("IBAN", "CH93 0076 2011 6238 5295 7");

        variables.put("customerId", customerId);
        when(execution.getVariable("customerId")).thenReturn(customerId);
        when(userService.getUserDetails(anyInt())).thenReturn(expectedUser);

        // Act
        handler.getUserDetails().execute(execution);


        // Assert
        verify(userService, times(1)).getUserDetails(customerId);
        verify(execution, times(1)).setVariable("userDetails",expectedUser);
    }

    @Test
    void testGetUserDetailsWithException() throws IOException {
        // Arrange
        int customerId = 123;
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerId", customerId);
        when(execution.getVariable("customerId")).thenReturn(customerId);
        when(userService.getUserDetails(customerId)).thenThrow(new IOException());

        // Act & Assert
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> handler.getUserDetails().execute(execution));
    }
}
