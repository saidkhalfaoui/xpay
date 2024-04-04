package com.henripay.sepadd.mapper;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.sepadd.api.model.DirectDebitRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface DirectDebitRequestMapper {

    TransactionEntity toEntity(DirectDebitRequest source);

    List<TransactionEntity> toEntityList(List<DirectDebitRequest> source);

    DirectDebitRequest toDto(TransactionEntity source);

    List<DirectDebitRequest> toDtoList(List<TransactionEntity> source);

}
