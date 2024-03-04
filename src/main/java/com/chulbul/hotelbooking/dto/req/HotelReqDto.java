package com.chulbul.hotelbooking.dto.req;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HotelReqDto {
    private String name;
    private String location;
    private String description;
    private String rating;
}
