package com.henripay.spellclientservice.api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DirectPostRequestDto {
    private String cardholderName;
    private String cardNumber;
    private String expires;
    private String cvc;
    private String rememberCard;
    private String remoteIp;
    private String userAgent;
    private String acceptHeader;
    private String language;
    private boolean javaEnabled;
    private boolean javascriptEnabled;
    private int colorDepth;
    private int utcOffset;
    private int screenWidth;
    private int screenHeight;
}
