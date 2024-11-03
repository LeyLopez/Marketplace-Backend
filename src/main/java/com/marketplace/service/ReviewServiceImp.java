package com.marketplace.service;

import com.marketplace.dto.ReviewDTO;
import com.marketplace.dto.ReviewMapper;
import com.marketplace.entity.Review;
import com.marketplace.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewServiceImp(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }


    @Override
    public Optional<ReviewDTO> findById(Long id) {
        return reviewRepository.findById(id).map(reviewMapper::toDto);
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(dto->reviewMapper.toDto(dto)).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Review review = reviewRepository.save(reviewMapper.toEntity(reviewDTO));
        return reviewMapper.toDto(review);
    }

    @Override
    public Optional<ReviewDTO> update(Long id, ReviewDTO reviewDTO) {
        return reviewRepository.findById(id)
                .map(reviewInBD->{
                    reviewInBD.setCalification(reviewDTO.calification());
                    reviewInBD.setComment(reviewDTO.comment());
                    reviewInBD.setClient(reviewDTO.client());
                    reviewInBD.setSalesman(reviewDTO.salesman());
                    reviewInBD.setProduct(reviewDTO.product());
                    reviewInBD.setResponse(reviewDTO.response());

                    return reviewRepository.save(reviewInBD);
                }).map(reviewMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
