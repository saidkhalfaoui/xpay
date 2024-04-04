package com.henripay.sepadd.mapper;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.sepadd.api.model.CreditTransferRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CreditTransferRequestMapper {

    TransactionEntity toEntity(CreditTransferRequest source);

    List<TransactionEntity> toEntityList(List<CreditTransferRequest> source);

    CreditTransferRequest toDto(TransactionEntity source);

    List<CreditTransferRequest> toDtoList(List<TransactionEntity> source);

}
