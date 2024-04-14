package com.henripay.spellclientservice.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.henripay.spellclientservice.dto.PurchaseResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface PurchaseResponseMapper {
    PurchaseResponseMapper INSTANCE = Mappers.getMapper(PurchaseResponseMapper.class);

    default PurchaseResponseDto mapFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return mapper.readValue(json, PurchaseResponseDto.class);
    }
}
