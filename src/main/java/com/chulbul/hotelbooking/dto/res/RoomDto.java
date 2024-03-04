package com.chulbul.hotelbooking.dto.res;

import com.chulbul.hotelbooking.enumm.RoomStatus;
import com.chulbul.hotelbooking.enumm.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomDto {
    private long id;
    private String roomNumber;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private double price;
    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;
}
