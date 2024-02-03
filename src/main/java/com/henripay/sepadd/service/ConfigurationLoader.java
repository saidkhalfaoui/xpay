package com.henripay.sepadd.service;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ConfigurationLoader {

    public static JobProperties loadJobConfiguration(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), JobProperties.class);
    }
    public static BankProperties loadBankConfiguration(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), BankProperties.class);
    }
}