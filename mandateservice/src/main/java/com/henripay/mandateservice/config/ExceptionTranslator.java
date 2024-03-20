package com.henripay.mandateservice.config;

import com.henripay.mandateservice.dto.Error;
import com.henripay.mandateservice.exception.NoValidInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.ws.rs.BadRequestException;


@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(NoValidInput.class)
    public ResponseEntity<Error> invalidInputValidation(final NoValidInput e) {
        return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError(e.getMessage(), (long) HttpStatus.NOT_FOUND.value()));
    }

    private Error getError(String message, Long code) {
        Error error = new Error();
        error.setMessage(message);
        error.setCode(code);
        return error;
    }
}
