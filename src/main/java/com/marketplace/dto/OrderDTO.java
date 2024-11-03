package com.marketplace.dto;

import com.marketplace.entity.OrderStatus;
import com.marketplace.entity.User;

public record OrderDTO(Long id,
                       Double total,
                       OrderStatus status,
                       User client) {
}
