package com.chulbul.hotelbooking.service.userservice.review;

import com.chulbul.hotelbooking.dto.req.ReviewReqDto;
import com.chulbul.hotelbooking.dto.res.ReviewDto;

import java.util.List;

public interface ReviewService {
    //Add review for an Hotel
    public ReviewDto addAReview(ReviewReqDto reviewReqDto);

    //Get All the Reviews
    public List<ReviewDto> getAlltheReviews();

    //Get Review By Id
    public ReviewDto getReviewById(long id);

    //Update the Review
    public ReviewDto updateReview(long id, ReviewReqDto reviewReqDto);

    public String deleteReview(long id);
 }
