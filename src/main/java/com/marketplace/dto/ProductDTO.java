package com.marketplace.dto;

import com.marketplace.entity.Category;
import com.marketplace.entity.ProductStatus;
import com.marketplace.entity.User;

public record ProductDTO(Long id,
                         String name,
                         String description,
                         Double price,
                         Integer availability,
                         String image,
                         ProductStatus status,
                         Category category,
                         User salesman) {
}
