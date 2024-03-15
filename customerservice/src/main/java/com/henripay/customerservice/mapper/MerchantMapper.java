package com.henripay.customerservice.mapper;

import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.domainservice.entity.MerchantEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MerchantMapper {
    //@Mapping(target = "merchantId", ignore = true)
    MerchantEntity toEntity(MerchantDTO source);
    List<MerchantEntity> toEntityList(List<MerchantDTO> source);
    MerchantDTO toDto(MerchantEntity source);
    List<MerchantDTO> toDtoList(List<MerchantEntity> source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(MerchantDTO dto, @MappingTarget MerchantEntity entity);

}
