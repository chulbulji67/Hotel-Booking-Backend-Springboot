package com.chulbul.hotelbooking.service.userservice.booking;

import com.chulbul.hotelbooking.dto.req.BookingReqDto;
import com.chulbul.hotelbooking.dto.res.BookingDto;

import java.util.List;

public interface BookingService {
    //Add a booking
    public BookingDto addABooking(BookingReqDto bookingReqDto);

    //Get All Booking
    public List<BookingDto> getAllBookings();

    //Get Bookings By Id
    public BookingDto getBookingById(long id);

    //UpdateBooking
    public BookingDto UpdateBookingById(long id, BookingReqDto bookingReqDto);

    //Delete Booking By id
    public String deleteBookingById(long id);
}
