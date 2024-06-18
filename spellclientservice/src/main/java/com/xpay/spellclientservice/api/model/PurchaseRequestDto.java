package com.xpay.spellclientservice.api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.spell.model.Product;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PurchaseRequestDto {
    @NotBlank(message = "Shouldn't be blank")
    @NotNull(message = "Shouldn't be null")
    @Email(message = "Invalid email")
    private String clientEmail;

    @NotEmpty(message = "Shouldn't be empty")
    private List<Product> products;

    private String brandId;

    private String currency;
}
