package com.henripay.spellclientservice.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDto {
    @NotBlank(message = "Shouldn't be blank")
    @NotNull(message = "Shouldn't be null")
    @Email(message = "Invalid email")
    private String clientEmail;

    @NotEmpty(message = "Shouldn't be empty")
    private List<ProductDto> products;

    @JsonProperty(value = "brand_id")
    private String brandId;

    private String currency;
}
