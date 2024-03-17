package com.henripay.mandateservice.mapper;

import com.henripay.domainservice.entity.MandateEntity;
import com.henripay.mandateservice.dto.MandateDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MandateMapper {

    @Mapping(target = "merchantId", ignore = true)
    @Mapping(target = "merchant.merchantId", source = "merchant")
    @Mapping(target = "customer.customerIdIdentifier", source = "customer")
    MandateEntity toEntity(MandateDTO source);
    List<MandateEntity> toEntityList(List<MandateDTO> source);
    @Mapping(source = "merchant.merchantId", target = "merchant")
    @Mapping(source = "customer.customerIdIdentifier", target = "customer")
    MandateDTO toDto(MandateEntity source);
    List<MandateDTO> toDtoList(List<MandateEntity> source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "merchant.merchantId", source = "merchant")
    @Mapping(target = "customer.customerIdIdentifier", source = "customer")
    void updateFromDto(MandateDTO dto, @MappingTarget MandateEntity entity);

}