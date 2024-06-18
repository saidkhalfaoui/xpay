package com.xpay.spellclientservice.api.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotNull
    @NotBlank(message = "Product name shouldn't be blank")
    private String name;

    @NotNull(message = "Product price shouldn't be null")
    @DecimalMin(value = "0", message = "Min Value should be greater than 0")
    private BigDecimal price;
}
