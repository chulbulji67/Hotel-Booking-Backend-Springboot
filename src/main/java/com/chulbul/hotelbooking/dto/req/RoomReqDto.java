package com.chulbul.hotelbooking.dto.req;

import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.enumm.RoomStatus;
import com.chulbul.hotelbooking.enumm.RoomType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomReqDto {
    private String roomNumber;

    private RoomType roomType;

    private double price;

    private RoomStatus roomStatus;

    private Hotel hotel;
}
