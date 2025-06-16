package com.ideal.gestion_note.utils;

import kong.unirest.Unirest;
import kong.unirest.ObjectMapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UnirestConfig {

    static {
        Unirest.config().setObjectMapper(new ObjectMapper() {
            private final com.fasterxml.jackson.databind.ObjectMapper jackson =
                    new com.fasterxml.jackson.databind.ObjectMapper()
                            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jackson.readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String writeValue(Object value) {
                try {
                    return jackson.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public static void init() {
    }

    public static void shutdown() {
        Unirest.shutDown();
    }
}
