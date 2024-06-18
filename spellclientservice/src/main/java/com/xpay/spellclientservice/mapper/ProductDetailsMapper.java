package com.xpay.spellclientservice.mapper;

import com.xpay.spellclientservice.api.model.ProductDto;
import com.spell.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductDetailsMapper {
    ProductDetailsMapper INSTANCE = Mappers.getMapper( ProductDetailsMapper.class );

    Product toProduct(ProductDto productDto);
}
