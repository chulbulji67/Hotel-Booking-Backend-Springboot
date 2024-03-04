package com.chulbul.hotelbooking.service.userservice.amenities;

import com.chulbul.hotelbooking.dto.req.AmenitiesReqDto;
import com.chulbul.hotelbooking.dto.res.AmenitiesDto;
import com.chulbul.hotelbooking.entity.Amenities;
import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.exception.amenities.AmenitiesNotFound;
import com.chulbul.hotelbooking.exception.hotelexception.HotelNotFoundException;
import com.chulbul.hotelbooking.repository.AmenitiesRepo;
import com.chulbul.hotelbooking.repository.HotelReop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenitiesServiceImpl implements AmenitiesService{

    @Autowired
    AmenitiesRepo amenitiesRepo;

    @Autowired
    HotelReop hotelReop;

    @Override
    public AmenitiesDto addAmenities(AmenitiesReqDto amenitiesReqDto) {
        //Get Hotel first in which you want to add amenities
        Hotel hotel = hotelReop.findById(amenitiesReqDto.getHotel().getId()).orElse(null);
        if(hotel == null){
            throw new HotelNotFoundException("Hotel Not Found with this id");

        }
        Amenities amenities = new Amenities();
        amenities.setDescription(amenitiesReqDto.getDescription());
        amenities.setName(amenitiesReqDto.getName());
        amenities.setHotel(hotel);

    return mapAmenityToAmenitiesDto(amenitiesRepo.save(amenities));
    }

    private AmenitiesDto mapAmenityToAmenitiesDto(Amenities amenities) {
        return AmenitiesDto.builder()
                .id(amenities.getId())
                .description(amenities.getDescription())
                .name(amenities.getName())
                .build();
    }

    @Override
    public List<AmenitiesDto> getAllAmenities() {
        return amenitiesRepo.findAll().stream().map(this::mapAmenityToAmenitiesDto).toList();
    }

    @Override
    public AmenitiesDto getAmenitiesById(long id) {
        //Check if Amenities Exist Or Not
        Amenities existingAmenities = amenitiesRepo.findById(id).orElse(null);
        if(existingAmenities == null){
            throw new AmenitiesNotFound("Amenities Not found with Id "+id);
        }

        return mapAmenityToAmenitiesDto(existingAmenities);
    }

    @Override
    public AmenitiesDto updateAmenitiesById(long id, AmenitiesReqDto amenitiesReqDto) {
        Amenities existingAmenities = amenitiesRepo.findById(id).orElse(null);
        if(existingAmenities == null){
            throw new AmenitiesNotFound("Amenities Not found with Id "+id);
        }
        existingAmenities.setName(amenitiesReqDto.getName());
        existingAmenities.setDescription(amenitiesReqDto.getDescription());

        existingAmenities.setHotel(hotelReop.findById(amenitiesReqDto.getHotel().getId()).orElse(null));

        return mapAmenityToAmenitiesDto(existingAmenities);
    }

    @Override
    public String deleteAmenitiesById(long id) {
        Amenities existingAmenities = amenitiesRepo.findById(id).orElse(null);
        if(existingAmenities == null){
            throw new AmenitiesNotFound("Amenities Not found with Id "+id);
        }
        amenitiesRepo.deleteById(id);

        return "Amenities Deleted Successfully";
    }

    @Override
    public List<AmenitiesDto> getAllAmenitiesInHotel(long id) {
        Hotel hotel = hotelReop.findById(id).orElse(null);
        if(hotel == null){
            throw new HotelNotFoundException("Hotel Not found With this id "+id);
        }
        List<Amenities> amenities= amenitiesRepo.findByHotel(hotel);
        return amenities.stream().map(this::mapAmenityToAmenitiesDto).toList();
    }
}
