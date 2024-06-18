package com.xpay.mandateservice.config;

import com.xpay.common.exception.InvalidInput;
import com.xpay.mandateservice.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(InvalidInput.class)
    public ResponseEntity<Error> invalidInputValidation(final InvalidInput e) {
        return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError(e.getMessage(), (long) HttpStatus.NOT_FOUND.value()));
    }

    private Error getError(String message, Long code) {
        Error error = new Error();
        error.setMessage(message);
        error.setCode(code);
        return error;
    }
}
