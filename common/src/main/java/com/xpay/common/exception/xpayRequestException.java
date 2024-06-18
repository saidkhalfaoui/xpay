package com.xpay.common.exception;

public class xpayRequestException extends RuntimeException {

    public xpayRequestException(String message) {
        super(message);
    }

    public xpayRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
