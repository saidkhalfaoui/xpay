package com.henripay.spellclientservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PurchaseDetailsMapper {
    PurchaseDetailsMapper INSTANCE = Mappers.getMapper(PurchaseDetailsMapper.class);

}
