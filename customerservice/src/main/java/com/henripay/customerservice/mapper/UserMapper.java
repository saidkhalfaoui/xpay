package com.henripay.customerservice.mapper;

import com.henripay.customerservice.dto.UserDTO;
import com.henripay.domainservice.entity.UserEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    @Mapping(target = "merchantId", ignore = true)
    @Mapping(target = "metadata.metadataId", source = "metadata")
    @Mapping(target = "aggregator.aggregatorId", source = "aggregator")
    UserEntity toEntity(UserDTO source);
    List<UserEntity> toEntityList(List<UserDTO> source);
    @Mapping(source = "metadata.metadataId", target = "metadata")
    @Mapping(source = "aggregator.aggregatorId", target = "aggregator")
    UserDTO toDto(UserEntity source);
    List<UserDTO> toDtoList(List<UserEntity> source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "metadata.metadataId", source = "metadata")
    @Mapping(target = "aggregator.aggregatorId", source = "aggregator")
    void updateFromDto(UserDTO dto, @MappingTarget UserEntity entity);
}
