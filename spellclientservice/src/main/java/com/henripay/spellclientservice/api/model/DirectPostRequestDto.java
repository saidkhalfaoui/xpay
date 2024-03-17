package com.henripay.spellclientservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectPostRequestDto {
    private String cardholderName;
    private String cardNumber;
    private String expires;
    private String cvc;
    private boolean rememberCard;
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
