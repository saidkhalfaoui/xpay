package com.xpay.common.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class xpayExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {xpayRequestException.class, InvalidInput.class})
    public ResponseEntity<Object> handlexpayBadRequestException(xpayRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        xpayException xpayException = new xpayException(e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        logger.error(e.getMessage());
        return new ResponseEntity<>(xpayException, badRequest);
    }

    @ExceptionHandler(value = {DataAccessException.class})
    public ResponseEntity<Object> handleDataAccessException(DataAccessException e) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        xpayException xpayException = new xpayException(
                "An error occurred while accessing the data store",
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        logger.error(e.getMessage(), e);
        return new ResponseEntity<>(xpayException, internalServerError);
    }

}
