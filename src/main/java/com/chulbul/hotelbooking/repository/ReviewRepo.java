package com.chulbul.hotelbooking.repository;

import com.chulbul.hotelbooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review , Long> {
}
