package com.marketplace.service;

import com.marketplace.dto.ResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ResponseService {

    Optional<ResponseDTO> findById(Long id);

    ResponseDTO save(ResponseDTO responseDTO);

    Optional<ResponseDTO> update(Long id, ResponseDTO responseDTO);

    void delete(Long id);

    List<ResponseDTO> findAll();

}
