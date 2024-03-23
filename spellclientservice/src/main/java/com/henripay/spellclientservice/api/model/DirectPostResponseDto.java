package com.henripay.spellclientservice.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DirectPostResponseDto {
    private String status;
    private String method;
    private String url;
    private String PaReq;
    private String md;
    private String callbackUrl;
}
