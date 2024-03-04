package com.chulbul.hotelbooking.dto.req;

import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.Room;
import com.chulbul.hotelbooking.entity.User;
import com.chulbul.hotelbooking.enumm.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingReqDto {
    private Date checkInDate;

    private Date checkOutDate;

    private BookingStatus bookingStatus;

    private double totalCost;

    private User user;

    private Room room;

    private Hotel hotel;
}
