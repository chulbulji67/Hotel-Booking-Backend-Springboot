package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.dto.req.AmenitiesReqDto;
import com.chulbul.hotelbooking.service.userservice.amenities.AmenitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class AmenitiesController {

    @Autowired
    AmenitiesService amenitiesService;

    //Add an Amenities
    @PostMapping("/amenities")
    public ResponseEntity<?> addAnAmenities(@RequestBody AmenitiesReqDto amenitiesReqDto){
        return ResponseEntity.status(201).body(amenitiesService.addAmenities(amenitiesReqDto));
    }

    //Get All amenities
    @GetMapping("/amenities")
    public ResponseEntity<?> getAllAmenities(){
        return ResponseEntity.status(200).body(amenitiesService.getAllAmenities());
    }

//    Get Amenities By id
    @GetMapping("/amenities/{id}")
    public ResponseEntity<?> getAmenitiesById(@PathVariable long id){
        return ResponseEntity.status(200).body(amenitiesService.getAmenitiesById(id));
    }

    //UpdateAmenities by id
    @PutMapping("/amenities/{id}")
    public ResponseEntity<?> updateAmenitiesById(@PathVariable long id, @RequestBody AmenitiesReqDto amenitiesReqDto){
        return ResponseEntity.status(200).body(amenitiesService.updateAmenitiesById(id, amenitiesReqDto));
    }

    //Delete Amenities By Id
    @DeleteMapping("/amenities/{id}")
    public ResponseEntity<String> deleteAmenitiesById(@PathVariable long id){
        return ResponseEntity.status(200).body(amenitiesService.deleteAmenitiesById(id));
    }

    //Get All Amenities in a Hotel
    @GetMapping("/{id}/amenities")
    public ResponseEntity<?> getAllAmenitiesInHotel(@PathVariable long id){
        return ResponseEntity.status(200).body(amenitiesService.getAllAmenitiesInHotel(id));
    }
}
