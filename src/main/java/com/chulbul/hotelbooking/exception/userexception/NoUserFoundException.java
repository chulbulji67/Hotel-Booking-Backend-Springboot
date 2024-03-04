package com.chulbul.hotelbooking.exception.userexception;

public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(String noUserExist) {
        super(noUserExist);
    }
}
