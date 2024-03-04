package com.chulbul.hotelbooking.exception.hotelexception;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String s) {
        super(s);
    }
}
