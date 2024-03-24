package com.henripay.spellclientservice.mapper;

import com.spell.model.BankAccount;
import com.spell.model.ClientDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper( BankAccountMapper.class );

}
