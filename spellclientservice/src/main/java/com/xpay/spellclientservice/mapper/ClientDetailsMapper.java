package com.xpay.spellclientservice.mapper;

import com.xpay.spellclientservice.api.model.PurchaseRequestDto;
import com.xpay.spellclientservice.api.model.PurchaseResDto;
import com.spell.model.ClientDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientDetailsMapper {
    ClientDetailsMapper INSTANCE = Mappers.getMapper( ClientDetailsMapper.class );
    default ClientDetails mapClientDetails(PurchaseRequestDto purchaseRequestDto) {
        // Map other fields as needed
        return new ClientDetails(purchaseRequestDto.getClientEmail());
    }

    default ClientDetails resToClientDetails(PurchaseResDto purchaseResDto) {
        return new ClientDetails(purchaseResDto.getClient().getEmail());
    }
}
