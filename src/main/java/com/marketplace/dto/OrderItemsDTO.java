package com.marketplace.dto;

import com.marketplace.entity.Order;
import com.marketplace.entity.Product;

public record OrderItemsDTO(Long id,
                            Integer quantity,
                            Order order,
                            Product product) {
}
