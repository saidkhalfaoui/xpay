package com.henripay.henripayapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MandateDetailsDto {
    private long mandateIdentifier;
    private long customer;
    private long merchant;
    private LocalDate signatureDate;
    private LocalDate startDate;
    private LocalDate endDate;
}
