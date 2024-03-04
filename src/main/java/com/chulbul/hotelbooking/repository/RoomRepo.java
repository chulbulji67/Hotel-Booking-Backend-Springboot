package com.chulbul.hotelbooking.repository;

import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    List<Room> findByHotel(Hotel hotel);
}
