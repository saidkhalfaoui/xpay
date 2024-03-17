package com.henripay.spellclientservice.config;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spell")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SpellConfig {
    private String apiKey;
    private String brandId;
    private String endpointUrl;
}
