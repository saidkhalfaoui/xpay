package com.xpay.sepadd.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

public class CsvFileHelper {
    public static Path writeCsvFile(List<String> csvData, String fileName) throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("csv");
        Path resourcePath = Paths.get(classPathResource.getURI());
        Path csvFilePath = resourcePath.resolve(fileName + ".csv");

        try {
            Files.write(csvFilePath, csvData);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return csvFilePath;
    }
}
