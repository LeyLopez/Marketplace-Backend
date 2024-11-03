package com.marketplace.service;

import com.marketplace.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductDTO> findById(Long id);

    Optional<ProductDTO> findByName(String name);

    List<ProductDTO> findAll();

    ProductDTO save(ProductDTO productDTO);

    void delete(Long id);

    Optional<ProductDTO> update(Long id, ProductDTO productDTO);

}
