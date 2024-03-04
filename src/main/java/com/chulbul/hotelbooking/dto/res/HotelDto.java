package com.chulbul.hotelbooking.dto.res;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HotelDto {
    private long id;
    private String name;
    private String location;
    private String description;
    private String rating;
}
