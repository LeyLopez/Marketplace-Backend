package com.marketplace.dto;

import com.marketplace.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    UserDTO toDtoWithoutId(User user);

    User toEntity(UserDTO userDTO);
}
