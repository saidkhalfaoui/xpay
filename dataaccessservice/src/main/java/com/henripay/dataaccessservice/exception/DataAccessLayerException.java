package com.henripay.dataaccessservice.exception;

public class DataAccessLayerException extends RuntimeException {

    public DataAccessLayerException(String message) {
        super(message);
    }

    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
