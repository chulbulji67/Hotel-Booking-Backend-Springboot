package com.chulbul.hotelbooking.repository;

import com.chulbul.hotelbooking.entity.Amenities;
import com.chulbul.hotelbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenitiesRepo extends JpaRepository<Amenities, Long> {
    List<Amenities> findByHotel(Hotel hotel);
}
