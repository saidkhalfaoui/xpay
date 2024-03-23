package com.henripay.spellclientservice.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChargePurchaseDto {
    @JsonProperty("recurring_token")
    private String recurringToken;
}
