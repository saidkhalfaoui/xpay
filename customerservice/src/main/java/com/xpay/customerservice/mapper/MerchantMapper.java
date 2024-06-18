package com.xpay.customerservice.mapper;

import com.xpay.customerservice.dto.MerchantDTO;
import com.xpay.domainservice.entity.MerchantEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MerchantMapper {
    //@Mapping(target = "merchantId", ignore = true)
    //@Mapping(target = "merchantName", source = "dto.metadata")
    @Mapping(target = "merchantId", ignore = true)
    @Mapping(target = "metadata.metadataId", source = "metadata")
    @Mapping(target = "aggregator.aggregatorId", source = "aggregator")

    MerchantEntity toEntity(MerchantDTO source);
    List<MerchantEntity> toEntityList(List<MerchantDTO> source);
    @Mapping(source = "metadata.metadataId", target = "metadata")
    @Mapping(source = "aggregator.aggregatorId", target = "aggregator")
    MerchantDTO toDto(MerchantEntity source);
    List<MerchantDTO> toDtoList(List<MerchantEntity> source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "metadata.metadataId", source = "metadata")
    @Mapping(target = "aggregator.aggregatorId", source = "aggregator")
    void updateFromDto(MerchantDTO dto, @MappingTarget MerchantEntity entity);

}
