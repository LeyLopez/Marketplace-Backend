package com.marketplace.controller;

import com.marketplace.dto.ReviewDTO;
import com.marketplace.entity.Response;
import com.marketplace.exceptions.NotFoundException;
import com.marketplace.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin("*")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        return reviewService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Review with id " + id + " not found"));
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewService.findAll());
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = reviewService.save(reviewDTO);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        return reviewService.update(id, reviewDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException("Review with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDTO> deleteReview(@PathVariable Long id) {
        return reviewService.findById(id).map(r->{
            reviewService.delete(id);
            return ResponseEntity.ok().body(r);
        }).orElseThrow(() -> new NotFoundException("Review with id " + id + " not found"));
    }
}
