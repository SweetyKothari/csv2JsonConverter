package com.codapayment.assignment;

import com.codapayment.assignment.config.UserInput;
import com.codapayment.assignment.util.ApplicationConstant;
import com.codapayment.assignment.util.DataTypeFinder;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.codapayment.assignment.CustomFileWriter.writeToFile;
import static com.codapayment.assignment.JsonGenerator.getJsonString;


/**
 * This class is responsible for reading CSV Data & convert to Json
 */
public class CSV2JsonConverter {

    private static Logger logger = Logger.getLogger(CSV2JsonConverter.class);
    private UserInput userInput = null;
    private static List<String> headerList = null;

    CSV2JsonConverter(UserInput userInput) {
        this.userInput = userInput;
    }

    /**
     * This method returns list of header key of CSV file
     *
     * @return
     * @throws IOException
     */
    private List<String> setHeader() {
        File file = new File(userInput.getInputFilePath());
        if (!file.exists()) {
            logger.error("File is not present ");
            System.exit(0);
        }
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            headerList = Arrays.asList(br.readLine().split(ApplicationConstant.COMMA));
        } catch (FileNotFoundException e) {
            logger.error("File is not present ", e.getCause());
        } catch (IOException e) {
            logger.error("IOException  ", e.getCause());
        }
        logger.info("Getting Header of CSV File ");
        return headerList;
    }

    /**
     * This method reads CSV file & get json
     *
     * @throws IOException
     */
    public long readCSVNConvertToJson() {
        //set to initial value
        CustomFileWriter.index.set(0);
        if (null == headerList) setHeader();
        try (BufferedReader br = new BufferedReader(new FileReader(userInput.getInputFilePath()))) {
            br.lines().skip(1).parallel()
                    .map(csvString -> mapToJsonString.apply(csvString, userInput.isDataType()))
                    .forEach(content -> writeToFile(content, userInput.getOutputFilePath()));
        } catch (FileNotFoundException e) {
            logger.error("File is not present ", e.getCause());
        } catch (IOException e) {
            logger.error("IOException  ", e.getCause());
        }
        return CustomFileWriter.index.get();
    }

    /**
     * Function to create json map by value & dataType
     */
    private static Function<String, Object> createJsonMap = (value) -> {
        Map<String, String> innerMap1 = new HashMap<>();
        innerMap1.put(ApplicationConstant.DATA_TYPE, DataTypeFinder.getDataType(value).name());
        innerMap1.put(ApplicationConstant.VALUE, value);
        return innerMap1;
    };

    /**
     * This is BiFunction to convert json String
     */
    private static BiFunction<String, Boolean, String> mapToJsonString = (line, dataTypeReqd) -> {
        logger.debug("Starting mapToItem :");
        String[] valueArr = line.split(ApplicationConstant.COMMA);
        Map<String, Object> jsonMap = new LinkedHashMap<>();
        for (int i = 0; i < valueArr.length; i++) {
            Object innerMap = valueArr[i];
            if (dataTypeReqd) {
                innerMap = createJsonMap.apply(valueArr[i]);
            }
            jsonMap.put(headerList.get(i), innerMap);
        }
        return getJsonString(jsonMap);
    };


}

