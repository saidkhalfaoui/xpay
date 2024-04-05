package com.henripay.customerservice.config;

import com.henripay.customerservice.dto.Error;
import com.henripay.domainservice.exception.InvalidInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(InvalidInput.class)
    public ResponseEntity<Error> invalidInputValidation(final InvalidInput e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(getError(e.getMessage(), (long) NOT_FOUND.value()));
    }

    private Error getError(String message, Long code) {
        Error error = new Error();
        error.setMessage(message);
        error.setCode(code);
        return error;
    }
}
