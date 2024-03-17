package com.henripay.customerservice.mapper;

import com.henripay.customerservice.dto.UserDTO;
import com.henripay.domainservice.entity.UserEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    @Mapping(target = "customerIdIdentifier", ignore = true)
    UserEntity toEntity(UserDTO source);
    List<UserEntity> toEntityList(List<UserDTO> source);

    UserDTO toDto(UserEntity source);
    List<UserDTO> toDtoList(List<UserEntity> source);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(UserDTO dto, @MappingTarget UserEntity entity);
}
