package com.codapayment.assignment.util;

import java.util.regex.Pattern;

public class DataTypeFinder {

    public static  DataTypes getDataType(String inputVal) {
        if( Pattern.matches(DataTypes.Email.regEx,inputVal)){
            return DataTypes.Email;
        }
        else if (Pattern.matches(DataTypes.Number.regEx,inputVal)){
            return DataTypes.Number;
        }
        else if (Pattern.matches(DataTypes.PhoneNumber.regEx,inputVal)){
            return DataTypes.PhoneNumber;
        }
        else if (Pattern.matches(DataTypes.Web.regEx,inputVal)){
            return DataTypes.Web;
        }
        else {
            return DataTypes.String;
        }
    }
}
