package com.henripay.spellclientservice.mapper;

import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.spell.model.ClientDetails;
import com.spell.model.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {
    PurchaseMapper INSTANCE = Mappers.getMapper( PurchaseMapper.class );

    @Mapping(target = "client.email", source = "clientEmail")
    @Mapping(target = "purchase.products", source = "products")
    @Mapping(target = "brandId", source = "brandId")
    @Mapping(target = "purchase.currency", source = "currency")
    Purchase toPurchase(PurchaseRequestDto purchaseRequestDto);

    default ClientDetails mapClientDetails(PurchaseRequestDto purchaseRequestDto) {
        // Map other fields as needed
        return new ClientDetails(purchaseRequestDto.getClientEmail());
    }
    default UUID mapStringToUUID(String uuidString) {
        return uuidString != null ? UUID.fromString(uuidString) : null;
    }
}
