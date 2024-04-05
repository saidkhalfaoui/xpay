package com.henripay.henripayapi.web.error;

public class InvalidInput extends RuntimeException {

    public InvalidInput(String message) {
        super(message);
    }
}

