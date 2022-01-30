package com.solvd.onlinestore.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Jackson {
    private static final Logger LOGGER = LogManager.getLogger(Jackson.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();


    private static void serialize(File file) {
        try {
            String json = MAPPER.writeValueAsString(file);
            LOGGER.info(json);
        } catch (JsonProcessingException e){
            LOGGER.error(e);
        }
    }

    public static <T> T deserialize(String jsonString, Class<T> cls){
        T result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.readValue(jsonString,cls);
        } catch (JsonProcessingException e) {
            LOGGER.error(e);
        }
        return result;
    }
}
