package com.marketplace.dto;

import com.marketplace.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    @Mapping(target="id", ignore = true)
    CategoryDTO toDtoWithoutId(Category category);

    Category toEntity(CategoryDTO categoryDTO);


}
