package com.henripay.common.crypto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class CryptoConfig {

    @Value("${crypto.googleKms.projectId}")
    private String projectId;

    @Value("${crypto.googleKms.location}")
    private String location;

}
