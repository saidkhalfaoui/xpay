package com.henripay.customerservice.mapper;

import com.henripay.customerservice.dto.AggregatorDTO;
import com.henripay.customerservice.dto.MerchantDTO;
import com.henripay.domainservice.entity.AggregatorEntity;
import com.henripay.domainservice.entity.MerchantEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AggregatorMapper {
    AggregatorEntity toEntity(AggregatorDTO source);
    AggregatorDTO toDto(AggregatorEntity source);

}
