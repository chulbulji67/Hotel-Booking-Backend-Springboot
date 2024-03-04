package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.dto.req.BookingReqDto;
import com.chulbul.hotelbooking.service.userservice.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    //Add a Booking
    @PostMapping
    public ResponseEntity<?> addABooking(@RequestBody BookingReqDto bookingReqDto){
        return ResponseEntity.status(201).body(bookingService.addABooking(bookingReqDto));
    }

    //Get All the Bookings
    @GetMapping
    public ResponseEntity<?> getAllBookins(){
        return ResponseEntity.status(200).body(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable long id){
        return ResponseEntity.status(200).body(bookingService.getBookingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookingById(@PathVariable long id, @RequestBody BookingReqDto bookingReqDto){
        return ResponseEntity.status(200).body(bookingService.UpdateBookingById(id,bookingReqDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookingById(@PathVariable long id){
        return ResponseEntity.status(200).body(bookingService.deleteBookingById(id));
    }
}
