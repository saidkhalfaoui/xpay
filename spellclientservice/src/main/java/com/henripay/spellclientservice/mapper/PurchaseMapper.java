package com.henripay.spellclientservice.mapper;

import com.henripay.spellclientservice.api.model.PurchaseRequestDto;
import com.henripay.spellclientservice.api.model.PurchaseResDto;
import com.spell.model.ClientDetails;
import com.spell.model.Purchase;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
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
