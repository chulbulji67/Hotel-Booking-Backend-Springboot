package com.chulbul.hotelbooking.service.userservice.booking;

import com.chulbul.hotelbooking.dto.req.BookingReqDto;
import com.chulbul.hotelbooking.dto.res.BookingDto;
import com.chulbul.hotelbooking.entity.Booking;
import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.Room;
import com.chulbul.hotelbooking.exception.bookingexception.BookingNotFoundException;
import com.chulbul.hotelbooking.repository.BookingRepo;
import com.chulbul.hotelbooking.repository.HotelReop;
import com.chulbul.hotelbooking.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelReop hotelReop;


    @Override
    public BookingDto addABooking(BookingReqDto bookingReqDto) {
        Booking booking = Booking.builder()
                .bookingStatus(bookingReqDto.getBookingStatus())
                .totalCost(bookingReqDto.getTotalCost())
                .user(bookingReqDto.getUser())
                .checkOutDate(bookingReqDto.getCheckOutDate())
                .checkInDate(bookingReqDto.getCheckInDate()).build();
        booking.setRoom(bookingReqDto.getRoom());
        booking.setHotel(bookingReqDto.getHotel());

        bookingRepo.save(booking);
        bookingReqDto.setHotel(hotelReop.findById(bookingReqDto.getHotel().getId()).orElse(null));
        bookingReqDto.setRoom(roomRepo.findById(bookingReqDto.getRoom().getId()).orElse(null));
        return bookingReqDtoToBookingDto(bookingReqDto);
    }

    @Override
    public List<BookingDto> getAllBookings() {

        return bookingRepo.findAll().stream().map(this::bookingToBooingDto).toList();
    }

    private BookingDto bookingToBooingDto(Booking booking) {
        return BookingDto.builder()
                .id(booking.getId())
                .checkOutDate(booking.getCheckOutDate())
                .checkInDate(booking.getCheckInDate())
                .hotelName(booking.getHotel().getName())
                .roomNumber(booking.getRoom().getRoomNumber())
                .totalCost(booking.getTotalCost())
                .bookingStatus(booking.getBookingStatus()).build();
    }

    @Override
    public BookingDto getBookingById(long id) {
        Booking booking = bookingRepo.findById(id).orElse(null);
        if(booking == null) {
            throw new BookingNotFoundException("Booking not found with id "+id);
        }
        return bookingToBooingDto(booking);
    }

    @Override
    public BookingDto UpdateBookingById(long id, BookingReqDto bookingReqDto) {
        Booking existingBooking = bookingRepo.findById(id).orElse(null);
        if(existingBooking == null) {
            throw new BookingNotFoundException("Booking not found with id "+id);
        }

       Hotel hotel =  hotelReop.findById(bookingReqDto.getHotel().getId()).orElse(hotelReop.findById(existingBooking.getHotel().getId()).orElse(null));
        Room room = roomRepo.findById(bookingReqDto.getRoom().getId()).orElse(roomRepo.findById(existingBooking.getRoom().getId()).orElse(null));

        existingBooking.setBookingStatus(bookingReqDto.getBookingStatus());
        existingBooking.setHotel(hotel);
        existingBooking.setRoom(room);
        existingBooking.setCheckInDate(bookingReqDto.getCheckInDate());
        existingBooking.setTotalCost(bookingReqDto.getTotalCost());
        existingBooking.setCheckOutDate(bookingReqDto.getCheckOutDate());



        return bookingToBooingDto(existingBooking);
    }

    @Override
    public String deleteBookingById(long id) {
        Booking existingBooking = bookingRepo.findById(id).orElse(null);
        if(existingBooking == null) {
            throw new BookingNotFoundException("Booking not found with id "+id);
        }
        bookingRepo.deleteById(id);
        return "Deleted Successfully";
    }

   public BookingDto bookingReqDtoToBookingDto(BookingReqDto bookingReqDto){
        return BookingDto.builder()

                .checkInDate(bookingReqDto.getCheckInDate())
                .checkOutDate(bookingReqDto.getCheckOutDate())
                .totalCost(bookingReqDto.getTotalCost())
                .bookingStatus(bookingReqDto.getBookingStatus())
                .roomNumber(bookingReqDto.getRoom().getRoomNumber())
                .hotelName(bookingReqDto.getHotel().getName())
                .build();

    }
}
