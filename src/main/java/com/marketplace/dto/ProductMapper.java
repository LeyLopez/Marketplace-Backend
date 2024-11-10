package com.marketplace.dto;

import com.marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    @Mapping(target = "id", ignore = true)
    ProductDTO toDtoWithoutId(Product product);

    Product toEntity(ProductDTO productDTO);
}
