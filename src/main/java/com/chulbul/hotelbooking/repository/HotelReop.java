package com.chulbul.hotelbooking.repository;

import com.chulbul.hotelbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelReop extends JpaRepository<Hotel, Long> {
}
