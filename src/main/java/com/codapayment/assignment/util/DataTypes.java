package com.codapayment.assignment.util;

import static com.codapayment.assignment.util.ApplicationConstant.*;

public enum DataTypes {
    String(STRING_REGX),Number(NUMBER_REGX),PhoneNumber(PHONE_NO_REGX),Email(EMAIL_REGX),Web(WEB_URL_REGX);
    public String regEx;
    private DataTypes(String regEx) {
        this.regEx = regEx;
    }
}
