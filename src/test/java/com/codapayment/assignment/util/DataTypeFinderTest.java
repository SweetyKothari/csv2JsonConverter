package com.codapayment.assignment.util;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DataTypeFinderTest {

    @Test
    public void testMethodForString(){
        assertEquals(DataTypeFinder.getDataType("1212aa").name() , DataTypes.String.name());
        assertEquals(DataTypeFinder.getDataType("FirstName").name() , DataTypes.String.name());
    }
    @Test
    public void testMethodForPhone(){
        assertEquals(DataTypeFinder.getDataType("1212").name() , DataTypes.Number.name());
        assertEquals(DataTypeFinder.getDataType("12120909090909").name() , DataTypes.Number.name());
    }
    @Test
    public void testMethodForEmail(){
        assertEquals(DataTypeFinder.getDataType("1212@gmail.com").name() , DataTypes.Email.name());
        assertEquals(DataTypeFinder.getDataType("test@yahoo.com").name() , DataTypes.Email.name());
    }
    @Test
    public void testMethodForPhoneNumber(){
        assertEquals(DataTypeFinder.getDataType("233-344-2222").name() , DataTypes.PhoneNumber.name());
        assertEquals(DataTypeFinder.getDataType("+91-22900002").name() , DataTypes.PhoneNumber.name());
    }
    @Test
    public void testMethodForWeb(){
        assertEquals(DataTypeFinder.getDataType("http://google.com").name() , DataTypes.Web.name());
    }
}
