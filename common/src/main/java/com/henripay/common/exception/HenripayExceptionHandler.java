package com.henripay.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class HenripayExceptionHandler {
    @ExceptionHandler(value = {HenripayRequestException.class})
    public ResponseEntity<Object> handleHenripayBadRequestException(HenripayRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        HenripayException henripayException = new HenripayException(e.getMessage(),
                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(henripayException, badRequest);
    }

    @ExceptionHandler(value = {HenripayRequestException.class})
    public ResponseEntity<Object> handleHenripayNotFoundException(HenripayRequestException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        HenripayException henripayException = new HenripayException(e.getMessage(),
                e,
                notFound,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(henripayException, notFound);
    }
}
