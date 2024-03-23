package com.henripay.common.exception;

public class HenripayRequestException extends RuntimeException {

    public HenripayRequestException(String message) {
        super(message);
    }

    public HenripayRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
