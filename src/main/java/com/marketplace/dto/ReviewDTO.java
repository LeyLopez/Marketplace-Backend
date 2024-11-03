package com.marketplace.dto;

import com.marketplace.entity.Product;
import com.marketplace.entity.Response;
import com.marketplace.entity.User;

public record ReviewDTO(Long id,
                        Integer calification,
                        String comment,
                        User client,
                        User salesman,
                        Product product,
                        Response response) {
}
