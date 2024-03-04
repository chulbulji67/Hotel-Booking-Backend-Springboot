package com.chulbul.hotelbooking.entity;

import com.chulbul.hotelbooking.enumm.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends AbstractClass{
//    Attributes: bookingID, customerID, hotelID, roomID, checkInDate, checkOutDate,  totalCost
//    Relationships: belongs to a Hotel, relates to a Customer, allocated to a Room;

    private Date checkInDate;

    private Date checkOutDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private double totalCost;

    //Relationships

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


}
