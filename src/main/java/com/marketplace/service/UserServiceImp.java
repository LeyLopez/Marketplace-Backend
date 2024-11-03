package com.marketplace.service;

import com.marketplace.dto.UserDTO;
import com.marketplace.dto.UserMapper;
import com.marketplace.entity.User;
import com.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDto);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(dto->userMapper.toDto(dto)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> update(Long id, UserDTO userDTO) {
        return userRepository.findById(id)
                .map(userInBD->{
                    userInBD.setName(userDTO.name());
                    userInBD.setEmail(userDTO.email());
                    userInBD.setPassword(userDTO.password());
                    userInBD.setAddress(userDTO.address());
                    userInBD.setPhone(userDTO.phone());
                    userInBD.setLastname(userDTO.lastname());
                    userInBD.setRol(userDTO.rol());

                    return userRepository.save(userInBD);
                }).map(userMapper::toDto);
    }
}
