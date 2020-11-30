package com.codapayment.assignment;


import com.codapayment.assignment.config.UserInput;
import com.codapayment.assignment.util.Validator;
import org.apache.log4j.Logger;

import static com.codapayment.assignment.util.ApplicationConstant.CSV_EXT;

public class Main {
    private static Logger logger= Logger.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println((double)11/5);
        System.out.println("args "+args.length);
        if(args.length ==0){
            logger.info("Please use below command to run \n java -jar <jarFileName> <inputFilePath> <outputDirectory> <includeDataType(Y/N)> \n " +
                    "where includeDataType: default value is 'N' " );
            System.exit(0);
        }
        logger.info("Entered in Main");
        UserInput userInput = validateUserArguments(args);
        logger.info("Starting process of converting CSV 2 JSON");
        long startTime=System.currentTimeMillis();
        StartProcess(userInput);
        logger.info("Total Time of execution in ms : "+(System.currentTimeMillis()-startTime));
    }

    private static UserInput validateUserArguments(String[] args) {
        UserInput userInput= null;
        if(args.length>0){
            String inputFilePath=args[0];
            boolean canParse=inputFilePath.endsWith(CSV_EXT);
            if(canParse){
                userInput= new UserInput();
                userInput.setInputFilePath(inputFilePath);
            } else{
                logger.info("input file is not CSV ");
                System.exit(0);
            }
        }
        if(args.length >1){
            String outputDirectory=args[1];
            userInput.setOutputFilePath(outputDirectory);
        }
        if(args.length >2){
            String includeDataType=args[2];
            if(!Validator.contains(includeDataType)){
                logger.info("Only (Y/N) is allowed");
                System.exit(0);
            }
            else{
                userInput.setDataType(includeDataType.equals(Validator.YOrNEnumType.Y.name()));
            }
        }
        return userInput;
    }

    private static void StartProcess(UserInput userInput) {
        CSV2JsonConverter csvReader= new CSV2JsonConverter(userInput);
        long totalRecords=csvReader.readCSVNConvertToJson();
        logger.info("Total No.of Files got created at "+userInput.getOutputFilePath()+": "+totalRecords);
    }

}
