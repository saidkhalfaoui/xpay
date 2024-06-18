package com.xpay.spellclientservice.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class EnumDeserializer<T extends Enum<T>> extends StdDeserializer<T> {

    private final Class<T> enumClass;

    public EnumDeserializer(Class<T> enumClass) {
        super(enumClass);
        this.enumClass = enumClass;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText().trim().toUpperCase();
        return T.valueOf(enumClass, value);
    }
}
