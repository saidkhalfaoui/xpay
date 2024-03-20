package com.henripay.spellclientservice.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class RefundPurchaseDto {
    @NotNull
    @NotEmpty
    @Positive
    private Long amount;
}
