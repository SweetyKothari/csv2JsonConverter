package com.codapayment.assignment.config;

import com.codapayment.assignment.util.ApplicationConstant;

/**
 * This POJO is to handle user provided argument
 */
public class UserInput {
    private String inputFilePath;
    private String outputFilePath;
    private String type= ApplicationConstant.JSON;
    private boolean isDataType=false;

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDataType() {
        return isDataType;
    }

    public void setDataType(boolean dataType) {
        isDataType = dataType;
    }
}
