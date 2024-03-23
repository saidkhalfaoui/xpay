package com.henripay.spellclientservice.config;

import lombok.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(RestClientException.class)
    public ErrorResponse handleHttpCallException(RestClientException ex) {
        // Log the exception
        // You can customize the error response based on your requirement
        return new ErrorResponse("HTTP Call Error", ex.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ErrorResponse handleIOException(IOException ex) {
        // Log the exception or perform additional operations
        return new ErrorResponse("IOException Error", ex.getMessage());

    }


    @Data
    public static class ErrorResponse {
        // Getters and setters
        private String message;
        private String details;

        public ErrorResponse(String message, String details) {
            this.message = message;
            this.details = details;
        }
    }
}
