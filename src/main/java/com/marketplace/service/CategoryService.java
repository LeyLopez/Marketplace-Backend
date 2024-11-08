package com.marketplace.service;

import com.marketplace.dto.CategoryDTO;


import java.util.List;
import java.util.Optional;

public interface CategoryService {



    Optional<CategoryDTO> findById(Long id);

    List<CategoryDTO> findAll();

    CategoryDTO save(CategoryDTO categoryDTO);

    Optional<CategoryDTO> update(Long id, CategoryDTO categoryDTO);

    void delete(Long id);

    Optional<CategoryDTO> findByName(String name);

}
