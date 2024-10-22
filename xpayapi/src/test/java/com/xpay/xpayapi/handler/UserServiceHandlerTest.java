package com.xpay.xpayapi.handler;

import com.xpay.xpayapi.client.UserClient;
import com.xpay.xpayapi.dto.UserDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceHandlerTest {

    @Mock
    private UserClient userClient;

    @Mock
    private DelegateExecution execution;

    private UserServiceHandler userServiceHandler;

    @BeforeEach
    public void setup() {
        userServiceHandler = new UserServiceHandler(userClient);
    }

    @Test
    public void testGetUserDetails_Success() throws Exception {
        // Arrange
        Long customerId = 1L;
        UserDTO expectedUserDTO = new UserDTO();
        when(execution.getVariable("customerId")).thenReturn(customerId);
        when(userClient.getUserDetails(customerId)).thenReturn(expectedUserDTO);

        // Act
        userServiceHandler.getUserDetails().execute(execution); // apply(execution);

        // Assert
        verify(execution, times(1)).setVariable("userDetails", expectedUserDTO);
    }

    @Test
    public void testGetUserDetails_Exception() {
        // Arrange
        Long customerId = 1L;
        when(execution.getVariable("customerId")).thenReturn(customerId);
        when(userClient.getUserDetails(customerId)).thenThrow(new RuntimeException("Service unavailable"));

        // Act & Assert
        // The test should not throw an exception since the exception is caught in the method
        assertThrows(RuntimeException.class, () -> userServiceHandler.getUserDetails().execute(execution));
    }
}
