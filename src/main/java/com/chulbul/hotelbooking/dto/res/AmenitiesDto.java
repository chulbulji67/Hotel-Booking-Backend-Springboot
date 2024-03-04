package com.chulbul.hotelbooking.dto.res;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AmenitiesDto {
    private long id;
    private String name;
    private String description;
}
