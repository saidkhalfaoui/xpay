package com.henripay.spellclientservice.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@NoArgsConstructor
public class PurchaseRequestDto {
    @NotNull(message = "Client shouldn't be null")
    private ClientDto client;
    @NotNull(message = "Purchase shouldn't be null")
    private PurchaseDto purchase;
    private String brandId;

    @Override
    public String toString(){
        return this.brandId;
        //return "Client: "+this.client.toString() + "\n purchase: "+this.purchase.toString();
    }
}
