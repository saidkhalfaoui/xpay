package com.henripay.spellclientservice.api.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto {
    @NotNull
    @NotBlank(message = "Product name shoudln't be blank")
    private String name;

    @NotNull(message = "Product price shoudln't be null")
    @DecimalMin(value = "0", message = "Min Value should be greater than 0")
    private BigDecimal price;

    @Override
    public String toString() {
        return "Product Name: "+this.name + " Price: "+this.price;
    }
}
