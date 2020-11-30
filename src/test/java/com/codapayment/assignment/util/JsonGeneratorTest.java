package com.codapayment.assignment.util;

import com.codapayment.assignment.JsonGenerator;
import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class JsonGeneratorTest {

    private Map<String,Object> createMockData(){
        Map<String, Object> valueMap= new HashMap<String,Object>();
        valueMap.put("first_name","SK");
        valueMap.put("last_name","");
        valueMap.put("contact_no","12112");
        return valueMap;
    }

    @Test
    public void getJsonStringTest(){
        assertEquals(JsonGenerator.getJsonString(createMockData()),"{\n" +
                "  \"contact_no\" : \"12112\",\n" +
                "  \"last_name\" : \"\",\n" +
                "  \"first_name\" : \"SK\"\n" +
                "}");

    }
}
