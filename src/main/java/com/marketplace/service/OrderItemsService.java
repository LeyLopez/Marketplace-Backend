package com.marketplace.service;

import com.marketplace.dto.OrderItemsDTO;

import java.util.List;
import java.util.Optional;

public interface OrderItemsService {

    Optional<OrderItemsDTO> findById(Long id);

    List<OrderItemsDTO> findAll();

    OrderItemsDTO save(OrderItemsDTO orderItemsDTO);

    void delete(Long id);

    Optional<OrderItemsDTO> update(Long id, OrderItemsDTO orderItemsDTO);
}
