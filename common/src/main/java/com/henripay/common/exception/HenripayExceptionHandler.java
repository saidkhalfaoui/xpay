package com.henripay.common.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class HenripayExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {HenripayRequestException.class})
    public ResponseEntity<Object> handleHenripayBadRequestException(HenripayRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        HenripayException henripayException = new HenripayException(e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(henripayException, badRequest);
    }

    @ExceptionHandler(value = {DataAccessException.class})
    public ResponseEntity<Object> handleDataAccessException(DataAccessException e) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;
        HenripayException henripayException = new HenripayException(
                "An error occurred while accessing the data store",
                e,
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(henripayException, internalServerError);
    }

}
