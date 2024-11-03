package com.marketplace.dto;

import com.marketplace.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {

    OrderDTO toDto(Order order);

    @Mapping(target = "id", ignore = true)
    OrderDTO toDtoWithoutId(Order order);

    Order toEntity(OrderDTO orderDTO);
}
