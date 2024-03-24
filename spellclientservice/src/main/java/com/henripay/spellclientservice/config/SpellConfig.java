package com.henripay.spellclientservice.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spell")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpellConfig {
    private String apiKey;
    private String henriApiKey;
    private String baseUrl;
    private String successRedirect;
    private String failureRedirect;
}
