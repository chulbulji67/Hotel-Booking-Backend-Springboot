package com.chulbul.hotelbooking.service.userservice.amenities;

import com.chulbul.hotelbooking.dto.req.AmenitiesReqDto;
import com.chulbul.hotelbooking.dto.res.AmenitiesDto;

import java.util.List;

public interface AmenitiesService {
    //Add Amenities
    public AmenitiesDto addAmenities(AmenitiesReqDto amenitiesReqDto);

    //Get All Amenities
    public List<AmenitiesDto> getAllAmenities();

    //Get Amenities By Id
    public AmenitiesDto getAmenitiesById(long id);

    //Update Amenities by Id
    public AmenitiesDto updateAmenitiesById(long id, AmenitiesReqDto amenitiesReqDto);

    //Delete Amenities By id
    public String deleteAmenitiesById(long id);

    //Get All Amenities For a Hotel
    public List<AmenitiesDto> getAllAmenitiesInHotel(long id);
}
