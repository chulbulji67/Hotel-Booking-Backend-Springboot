package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.dto.req.RoomReqDto;
import com.chulbul.hotelbooking.service.userservice.room.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
@Slf4j
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping
    public ResponseEntity<?> addRoom(@RequestBody RoomReqDto roomReqDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addRoom(roomReqDto));
    }

    @GetMapping
    public ResponseEntity<?> getAllRooms(){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomsById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable long id, @RequestBody RoomReqDto roomReqDto){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.updateRoom(id,roomReqDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.deleteRoom(id));
    }

    //Get All Rooms in A Hotel
    @GetMapping("/hotel/{hotel-id}")
    public ResponseEntity<?> getAllRoomsInHotel(@PathVariable(name = "hotel-id") long id){
        return ResponseEntity.status(200).body(roomService.getAllRoomsInHotel(id));
    }

}
