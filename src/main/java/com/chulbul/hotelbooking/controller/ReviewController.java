package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.dto.req.ReviewReqDto;
import com.chulbul.hotelbooking.service.userservice.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    //Add a review
    @PostMapping
    public ResponseEntity<?> addAReview(@RequestBody ReviewReqDto reviewReqDto){
        return ResponseEntity.status(201).body( reviewService.addAReview(reviewReqDto));
    }

    //Get All The revies
    @GetMapping
    public ResponseEntity<?> getAllReviews(){
        return ResponseEntity.status(200).body(reviewService.getAlltheReviews());
    }

    //Get The Review With their Id
    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable long id){
        return ResponseEntity.status(200).body(reviewService.getReviewById(id));
    }

    //Update the review By id and dto
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReviewBYId(@PathVariable long id, @RequestBody ReviewReqDto reviewReqDto){
        return ResponseEntity.status(200).body(reviewService.updateReview(id, reviewReqDto));
    }

    //Delete the review By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable long id){
        return ResponseEntity.status(200).body(reviewService.deleteReview(id));
    }
}
