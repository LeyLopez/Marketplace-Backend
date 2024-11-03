package com.marketplace.service;

import com.marketplace.dto.UserDTO;


import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserDTO> findById(Long id);

    Optional<UserDTO> findByEmail(String email);

    UserDTO save(UserDTO userDTO);

    List<UserDTO> findAll();

    void delete(Long id);

    Optional<UserDTO> update(Long id, UserDTO userDTO);
}
