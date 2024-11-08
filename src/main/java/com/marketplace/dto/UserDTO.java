package com.marketplace.dto;

import com.marketplace.entity.Rol;

public record UserDTO(Long id,
                      String username,
                      String name,
                      String lastname,
                      String email,
                      String password,
                      String phone,
                      String address,
                      Rol rol) {
}
