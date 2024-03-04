package com.chulbul.hotelbooking.exception.bookingexception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String s) {
        super(s);
    }
}
