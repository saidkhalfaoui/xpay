package com.xpay.spellclientservice.mapper;

import com.xpay.spellclientservice.api.model.PurchaseRequestDto;
import com.spell.model.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
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

    Purchase jsonToPurchase(String jsonStr, @MappingTarget Purchase purchase);

    default UUID mapStringToUUID(String uuidString) {
        return uuidString != null ? UUID.fromString(uuidString) : null;
    }
}
