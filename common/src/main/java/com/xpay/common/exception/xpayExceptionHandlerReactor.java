package com.xpay.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class xpayExceptionHandlerReactor extends ResponseEntityExceptionHandler {

    private final ObjectMapper objectMapper;

    public xpayExceptionHandlerReactor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleWebClientResponseException(WebClientResponseException ex) {
        String responseBody = ex.getResponseBodyAsString();
        return ResponseEntity
                .status(ex.getStatusCode())
//                .build();
                .body(responseBody);
    }


}
