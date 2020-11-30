package com.codapayment.assignment.util;

import org.apache.log4j.Logger;

public class Validator {
    private static Logger logger= Logger.getLogger(Validator.class);

    public enum YOrNEnumType {
        Y ,N;
    }

    public static boolean contains(String test) {
        boolean isValid = true;
        try {
            YOrNEnumType.valueOf(test.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.warn("Invalid Enum Type");
            isValid = false;
        }
        return isValid;
    }


}
