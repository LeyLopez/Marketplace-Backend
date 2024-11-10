package com.marketplace.dto;

import com.marketplace.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDto(Review review);

    @Mapping(target = "id", ignore = true)
    ReviewDTO toDtoWithoutId(Review review);

    Review toEntity(ReviewDTO reviewDTO);
}
