package com.marketplace.service;

import com.marketplace.dto.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<ReviewDTO> findById(Long id);

    List<ReviewDTO> findAll();

    ReviewDTO save(ReviewDTO reviewDTO);

    Optional<ReviewDTO> update(Long id, ReviewDTO reviewDTO);

    void delete(Long id);


}
