package com.marketplace.service;

import com.marketplace.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderDTO> findById(Long id);

    List<OrderDTO> findAll();

    OrderDTO save(OrderDTO orderDTO);

    void deleteById(Long id);

    Optional<OrderDTO> update(Long id, OrderDTO orderDTO);
}
