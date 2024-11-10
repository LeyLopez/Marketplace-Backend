package com.marketplace.dto;

import com.marketplace.entity.Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    ResponseDTO toDto(Response response);

    @Mapping(target = "id", ignore = true)
    ResponseDTO toDtoWithoutId(Response response);

    Response toEntity(ResponseDTO responseDTO);
}
