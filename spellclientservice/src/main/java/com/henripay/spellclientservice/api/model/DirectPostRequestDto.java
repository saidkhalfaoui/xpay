package com.henripay.spellclientservice.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectPostRequestDto {
    @JsonProperty("cardholder_name")
    private String cardholderName;
    @JsonProperty("card_number")
    private String cardNumber;
    private String expires;
    private String cvc;
    @JsonProperty("remember_card")
    private String rememberCard;
    @JsonProperty("remote_ip")
    private String remoteIp;
    @JsonProperty("user_agent")
    private String userAgent;
    @JsonProperty("accept_header")
    private String acceptHeader;
    private String language;
    @JsonProperty("java_enabled")
    private boolean javaEnabled;
    @JsonProperty("javascript_enabled")
    private boolean javascriptEnabled;
    @JsonProperty("color_depth")
    private int colorDepth;
    @JsonProperty("utc_offset")
    private int utcOffset;
    @JsonProperty("screen_width")
    private int screenWidth;
    @JsonProperty("screen_height")
    private int screenHeight;
}
