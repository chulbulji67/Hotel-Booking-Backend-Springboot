package com.chulbul.hotelbooking.service.userservice.hotel;

import com.chulbul.hotelbooking.dto.res.HotelDto;
import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.exception.hotelexception.HotelNotFoundException;
import com.chulbul.hotelbooking.repository.HotelReop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelReop hotelReop;

    @Override
    public HotelDto addHotel(Hotel hotel) {
        Hotel savedHotel = hotelReop.save(hotel);

        return HotelDto.builder()
                .id(savedHotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .location(hotel.getLocation())
                .rating(hotel.getRating())
                .build();
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return hotelReop.findAll().stream().map((this::mapToHotelDto)).toList();
    }

    private HotelDto mapToHotelDto(Hotel hotel) {
        return HotelDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .description(hotel.getDescription())
                .location(hotel.getLocation())
                .rating(hotel.getRating())
                .build();
    }

    @Override
    public HotelDto getHotelById(long id) {
        Hotel hotel = hotelReop.findById(id).orElse(null);
        if(hotel == null){
            throw new HotelNotFoundException("Hotel Not found with id "+id);
        }
        return mapToHotelDto(hotel);
    }

    @Override
    public HotelDto updateHotelById(long id, Hotel newHotel) {
        //Existing Hotel
        Hotel existingHotel = hotelReop.findById(id).orElse(null);
        if(existingHotel == null){
            throw new HotelNotFoundException("Hotel Not found with id "+id);
        }
        //Only Updating the name of the Hotel
        existingHotel.setName(newHotel.getName());
        hotelReop.save(existingHotel);

        return mapToHotelDto(existingHotel);
    }

    @Override
    public String deleteHotelById(long id) {
        Hotel existingHotel = hotelReop.findById(id).orElse(null);
        if(existingHotel == null){
            throw new HotelNotFoundException("Hotel Not found with id "+id);
        }
        hotelReop.deleteById(id);
        return "Deleted Successfully";
    }
}
