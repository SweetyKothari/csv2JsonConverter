package com.codapayment.assignment.util;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ValidatorTest {

    @Test
    public void testEnumContains(){
        assertEquals(Validator.contains("Y"),true);
        assertEquals(Validator.contains("N"),true);
        assertEquals(Validator.contains("nn"),false);
    }
}
