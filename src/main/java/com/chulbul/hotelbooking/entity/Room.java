package com.chulbul.hotelbooking.entity;

import com.chulbul.hotelbooking.enumm.RoomStatus;
import com.chulbul.hotelbooking.enumm.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Room extends AbstractClass{
//    Attributes: roomID, hotelID, roomNumber, type (e.g., single, double, suite), price, status (available, booked), amenities
//    Relationships: belongs to a Hotel, has multiple Bookings;

    private String roomNumber;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private double price;
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;


    //Relationships

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Booking> bookings;
}
