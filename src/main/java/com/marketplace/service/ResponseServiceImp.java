package com.marketplace.service;

import com.marketplace.dto.ResponseDTO;
import com.marketplace.dto.ResponseMapper;
import com.marketplace.entity.Response;
import com.marketplace.repository.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResponseServiceImp implements ResponseService {

    private final ResponseRepository responseRepository;
    private final ResponseMapper responseMapper;

    public ResponseServiceImp(ResponseRepository responseRepository, ResponseMapper responseMapper) {
        this.responseRepository = responseRepository;
        this.responseMapper = responseMapper;
    }


    @Override
    public Optional<ResponseDTO> findById(Long id) {
        return responseRepository.findById(id).map(responseMapper::toDto);
    }

    @Override
    public ResponseDTO save(ResponseDTO responseDTO) {
        Response response = responseRepository.save(responseMapper.toEntity(responseDTO));
        return responseMapper.toDto(response);
    }

    @Override
    public Optional<ResponseDTO> update(Long id, ResponseDTO responseDTO) {
        return responseRepository.findById(id)
                .map(responseInBD->{
                    responseInBD.setDescription(responseDTO.description());
                    responseInBD.setReview(responseDTO.review());

                    return responseRepository.save(responseInBD);
                }).map(responseMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        responseRepository.deleteById(id);
    }

    @Override
    public List<ResponseDTO> findAll() {
        return responseRepository.findAll().stream().map(dto->responseMapper.toDto(dto))
                .collect(Collectors.toList());
    }
}
