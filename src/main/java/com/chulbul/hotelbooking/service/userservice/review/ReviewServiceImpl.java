package com.chulbul.hotelbooking.service.userservice.review;

import com.chulbul.hotelbooking.dto.req.ReviewReqDto;
import com.chulbul.hotelbooking.dto.res.ReviewDto;
import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.Review;
import com.chulbul.hotelbooking.entity.User;
import com.chulbul.hotelbooking.exception.hotelexception.HotelNotFoundException;
import com.chulbul.hotelbooking.exception.reviewexception.ReviewNotFound;
import com.chulbul.hotelbooking.exception.userexception.NoUserFoundException;
import com.chulbul.hotelbooking.repository.HotelReop;
import com.chulbul.hotelbooking.repository.ReviewRepo;
import com.chulbul.hotelbooking.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    HotelReop hotelReop;

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public ReviewDto addAReview(ReviewReqDto reviewReqDto) {
        //Check If Hotel Exist Which You want to give Review
        Hotel hotel = hotelReop.findById(reviewReqDto.getHotel().getId()).orElse(null);
        if (hotel == null) {
            throw new HotelNotFoundException("Hotel Not found With Id ");
        }

        //Getting user By reviewReqDto
        User user = userRepo.findById(reviewReqDto.getUser().getId()).orElse(null);
        if (user == null) {
            throw new NoUserFoundException("User Not found With Id ");
        }

        Review review = new Review();
        review.setComment(reviewReqDto.getComment());
        review.setDate(reviewReqDto.getDate());
        review.setRating(reviewReqDto.getRating());
        review.setHotel(hotel);
        review.setUser(user);


        return reviewToReviewDto(reviewRepo.save(review));
    }

    @Override
    public List<ReviewDto> getAlltheReviews() {
       return reviewRepo.findAll().stream().map(this::reviewToReviewDto).toList();
    }

    private ReviewDto reviewToReviewDto(Review review) {
        return ReviewDto.builder()
                .date(review.getDate())
                .id(review.getId())
                .comment(review.getComment())
                .rating(review.getRating())
                .userName(review.getUser().getUsername())
                .build();
    }

    @Override
    public ReviewDto getReviewById(long id) {
        Review review = reviewRepo.findById(id).orElse(null);
        if(review == null){
            throw new ReviewNotFound("Review not found With the given Id");
        }
        return reviewToReviewDto(review);
    }

    @Override
    public ReviewDto updateReview(long id, ReviewReqDto reviewReqDto) {
        //Check if the review Exist?
        Review existingReview = reviewRepo.findById(id).orElse(null);
        if(existingReview == null){
            throw new ReviewNotFound("Review not found With the given Id");
        }

        Hotel hotel = hotelReop.findById(reviewReqDto.getHotel().getId()).orElse(null);
        if (hotel == null) {
            throw new HotelNotFoundException("Hotel Not found With Id ");
        }

        //Getting user By reviewReqDto
        User user = userRepo.findById(reviewReqDto.getUser().getId()).orElse(null);
        if (user == null) {
            throw new NoUserFoundException("User Not found With Id ");
        }

        existingReview.setComment(reviewReqDto.getComment());
        existingReview.setDate(reviewReqDto.getDate());
        existingReview.setRating(reviewReqDto.getRating());
        existingReview.setHotel(hotel);
        existingReview.setUser(user);

        return reviewToReviewDto(reviewRepo.save(existingReview));
    }

    @Override
    public String deleteReview(long id) {
        Review review = reviewRepo.findById(id).orElse(null);
        if(review == null){
            throw new ReviewNotFound("Review not found With the given Id");
        }
        reviewRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
