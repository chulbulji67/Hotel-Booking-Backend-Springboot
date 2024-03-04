package com.chulbul.hotelbooking.exception.roomexception;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String s) {
        super(s);
    }
}
