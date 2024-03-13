package com.henripay.customerservice.mapper;

import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.domainservice.entity.MerchantEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MerchantMapper {
    MerchantEntity merchantDtoToMerchantEntity(MerchantDTO source);
    List<MerchantEntity> merchantDTOSMerchantEntities(List<MerchantDTO> source);
    MerchantDTO merchantEntityToMerchantDto(MerchantEntity source);
    List<MerchantDTO> merchantEntitiesToMerchantDTOS(List<MerchantEntity> source);
}
