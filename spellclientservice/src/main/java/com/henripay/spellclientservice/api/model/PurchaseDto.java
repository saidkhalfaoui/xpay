package com.henripay.spellclientservice.api.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class PurchaseDto {
    @NotEmpty(message = "Shouldn't be empty")
    private List<ProductDto> products;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (ProductDto productDto: products) {
            str.append("\t ").append(productDto.toString());
        }
        return str.toString();
    }
}
