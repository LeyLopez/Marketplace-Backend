package com.marketplace.dto;

import com.marketplace.entity.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderItemsMapper {

    OrderItemsDTO toDto(OrderItems orderItems);

    @Mapping(target = "id", ignore = true)
    OrderItemsDTO toDtoWithoutId(OrderItems orderItems);

    OrderItems toEntity(OrderItemsDTO orderItemsDTO);
}
