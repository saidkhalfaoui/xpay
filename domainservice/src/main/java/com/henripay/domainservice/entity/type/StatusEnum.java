package com.henripay.domainservice.entity.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {

    ACCPETED("accpeted"),
    PROCESSED("processed"),
    NOTFOUND("notfound"),

    CREATED("created"),

    MISSING_MANDATORY_FIELDS("missing mandatory fields"),

    INVALID_FIELD_VALUES("invalid field values"),

    DUPLICATED("duplicated"),

    NOT_FOUND("not_found"),

    DELETED("deleted"),

    PROCESSING("processing"),

    COMPLETED("completed"),

    CANCELLED("cancelled");


    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
        for (StatusEnum b : StatusEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

}