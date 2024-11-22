package com.marketplace.dto;

import com.marketplace.entity.Rol;
import com.marketplace.entity.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    UserDTO toDtoWithoutId(User user);

    @Named("StringToRol")
    default Rol mapStringToRol(String rolString) {
        if (rolString != null) {
            return Rol.valueOf(rolString.toUpperCase());  // Convierte el string en mayúsculas a la enumeración
        }
        return null;  // Devuelve null si el String es null
    }

    @Mapping(source = "rol", target = "rol", qualifiedByName = "StringToRol")
    User toEntity(UserDTO userDTO);


}
