package com.chulbul.hotelbooking.exception;




import com.chulbul.hotelbooking.exception.amenities.AmenitiesNotFound;
import com.chulbul.hotelbooking.exception.bookingexception.BookingNotFoundException;
import com.chulbul.hotelbooking.exception.hotelexception.HotelNotFoundException;
import com.chulbul.hotelbooking.exception.reviewexception.ReviewNotFound;
import com.chulbul.hotelbooking.exception.roomexception.RoomNotFoundException;
import com.chulbul.hotelbooking.exception.userexception.NoUserFoundException;
import com.chulbul.hotelbooking.exception.userexception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<String > handleUsrNotFoundException(NoUserFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<String > handleUsrNotFoundException(HotelNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String > handleUsrNotFoundException(RoomNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String > handleUsrNotFoundException(BookingNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ReviewNotFound.class)
    public ResponseEntity<String > handleUsrNotFoundException(ReviewNotFound ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AmenitiesNotFound.class)
    public ResponseEntity<String > handleUsrNotFoundException(AmenitiesNotFound ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}