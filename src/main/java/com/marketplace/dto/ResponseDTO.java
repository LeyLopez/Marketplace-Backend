package com.marketplace.dto;

import com.marketplace.entity.Review;

public record ResponseDTO(Long id,
                          String description,
                          Review review) {
}
