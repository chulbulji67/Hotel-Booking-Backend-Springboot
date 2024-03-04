package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.dto.res.HotelDto;
import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.service.userservice.hotel.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    //Add a Hotel
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelDto addAHotel(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HotelDto> getAllHotel(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public HotelDto getHotelById(@PathVariable long id){
        return hotelService.getHotelById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelDto getHotelById(@PathVariable long id, @RequestBody Hotel hotel){
        return hotelService.updateHotelById(id, hotel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable long id){
        log.info("Delete Method is calling");
        return hotelService.deleteHotelById(id);
    }
}
