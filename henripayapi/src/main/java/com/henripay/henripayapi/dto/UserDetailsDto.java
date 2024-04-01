package com.henripay.henripayapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDetailsDto {
    private long customerIdIdentifier;
    private String iban;
    private String fullName;
    private String token;
    private String address;
    private LocalDateTime activationDate;
}
