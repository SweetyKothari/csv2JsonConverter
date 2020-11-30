package com.codapayment.assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.Map;

public class JsonGenerator {

    private static Logger logger= Logger.getLogger(JsonGenerator.class);
    private static ObjectMapper mapperObj = new ObjectMapper();

    /**
     * This method is responsible for getting json from Map
     * @param valueMap
     * @return
     */
    public static String getJsonString(Map<String, Object> valueMap){

        String jsonResp =null;
        try {
            jsonResp = mapperObj.writerWithDefaultPrettyPrinter().writeValueAsString(valueMap);
        } catch (JsonProcessingException e) {
            logger.error("Exception in parsing json ",e.getCause());
        }
        return jsonResp;

    }
}
