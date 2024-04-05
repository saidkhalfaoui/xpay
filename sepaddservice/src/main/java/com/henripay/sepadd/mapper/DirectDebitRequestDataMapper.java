package com.henripay.sepadd.mapper;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.sepadd.api.model.DirectDebitRequestData;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface DirectDebitRequestDataMapper {

    TransactionEntity toEntity(DirectDebitRequestData source);

    List<TransactionEntity> toEntityList(List<DirectDebitRequestData> source);

    DirectDebitRequestData toDto(TransactionEntity source);

    List<DirectDebitRequestData> toDtoList(List<TransactionEntity> source);

}
