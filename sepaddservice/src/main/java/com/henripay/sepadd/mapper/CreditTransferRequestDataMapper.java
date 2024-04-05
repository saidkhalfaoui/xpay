package com.henripay.sepadd.mapper;

import com.henripay.domainservice.entity.TransactionEntity;
import com.henripay.sepadd.api.model.CreditTransferRequestData;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CreditTransferRequestDataMapper {

    TransactionEntity toEntity(CreditTransferRequestData source);

    List<TransactionEntity> toEntityList(List<CreditTransferRequestData> source);

    CreditTransferRequestData toDto(TransactionEntity source);

    List<CreditTransferRequestData> toDtoList(List<TransactionEntity> source);

}
