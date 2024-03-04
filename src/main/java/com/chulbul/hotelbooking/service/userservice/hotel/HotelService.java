package com.chulbul.hotelbooking.service.userservice.hotel;

import com.chulbul.hotelbooking.dto.res.HotelDto;
import com.chulbul.hotelbooking.entity.Hotel;

import java.util.List;


public interface HotelService {

//    Add Hotel
    public HotelDto addHotel(Hotel hotel);

    //Get all hotels
    public List<HotelDto> getAllHotels();

    //Get Hotel by id
    public HotelDto getHotelById(long id);

//    Update Hotel
    public HotelDto updateHotelById(long id, Hotel newHotel);

    //Delete Hotel By Id
    public String deleteHotelById(long id);
}
