package com.codapayment.assignment;

import com.codapayment.assignment.config.UserInput;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class CSV2JsonConverterTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    Path resourceDirectory = Paths.get("src","test","resources");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    @Test
    public void readFileNGetJson() throws IOException {
        UserInput userInput= new UserInput();
        userInput.setInputFilePath(absolutePath+"/input.csv");
        File createdFolder= tempFolder.newFolder("subfolder");
        userInput.setOutputFilePath(createdFolder.getAbsolutePath()+"/");
        long val=new CSV2JsonConverter(userInput).readCSVNConvertToJson();
        assertEquals(val,4);
        try (Stream<Path> files = Files.list(Paths.get(createdFolder.getAbsolutePath()))) {
            long count = files.count();
            assertEquals(count,4);
        }

    }
}
