package com.henripay.sepadd.service.configuration;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CsvProperties {
    private String csvSeparator = ";";
}