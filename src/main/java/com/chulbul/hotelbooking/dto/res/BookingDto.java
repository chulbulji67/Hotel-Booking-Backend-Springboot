package com.chulbul.hotelbooking.dto.res;

import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.Room;
import com.chulbul.hotelbooking.enumm.BookingStatus;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingDto {
    private long id;
    private Date checkInDate;

    private Date checkOutDate;

    private BookingStatus bookingStatus;

    private double totalCost;

    private String roomNumber;

    private String hotelName;
}
