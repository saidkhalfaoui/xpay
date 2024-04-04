package com.henripay.sepadd.mapper;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.sepadd.api.model.TransactionStatusResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TransactionStatusResponseMapper {

    TransactionEntity toEntity(TransactionStatusResponse source);

    List<TransactionEntity> toEntityList(List<TransactionStatusResponse> source);

    TransactionStatusResponse toDto(TransactionEntity source);

    List<TransactionStatusResponse> toDtoList(List<TransactionEntity> source);

}
