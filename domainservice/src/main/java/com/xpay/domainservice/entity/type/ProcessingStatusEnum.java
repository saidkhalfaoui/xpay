package com.xpay.domainservice.entity.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProcessingStatusEnum {

    PENDING("pending"),

    PROCESSED("processed"),

    AUTHORIZED("authorized"),

    SETTLED("settled"),

    REFUNDED("refunded");

    private final String value;

    ProcessingStatusEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ProcessingStatusEnum fromValue(String value) {
        for (ProcessingStatusEnum b : ProcessingStatusEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}