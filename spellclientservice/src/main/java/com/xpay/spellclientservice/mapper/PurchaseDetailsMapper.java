package com.xpay.spellclientservice.mapper;

import com.spell.model.PurchaseDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PurchaseDetailsMapper {
    PurchaseDetailsMapper INSTANCE = Mappers.getMapper( PurchaseDetailsMapper.class );

}
