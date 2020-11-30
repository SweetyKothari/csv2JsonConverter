package com.codapayment.assignment;

import com.codapayment.assignment.util.ApplicationConstant;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This file is responsible for writing to a file
 */
public class CustomFileWriter {

    public static AtomicInteger index= new AtomicInteger(0);
    private static Logger logger= Logger.getLogger(CustomFileWriter.class);

    /**
     * This method is responsible for writing content in outputDir
     * @param content
     * @param outputDir
     */
    public static void writeToFile(String content,String outputDir)
    {
        try {
            Path path=Paths.get(outputDir);
            if(!Files.isWritable(path.getParent())){
              logger.info("can not write file to desired location ,provide different output location or parent directory is not found.");
              System.exit(0);
            }
            Files.createDirectories(path);
            Files.write(Paths.get(outputDir+ File.separator+ApplicationConstant.OUTPUT_FILE_PRE + index.getAndIncrement() + ApplicationConstant.JSON_FILE_EXT), content.getBytes());
        } catch (IOException e) {
            logger.error("Exception in write to file "+e.getCause());
        }
    }

}
