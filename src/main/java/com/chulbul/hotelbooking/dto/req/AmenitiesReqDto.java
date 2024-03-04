package com.chulbul.hotelbooking.dto.req;

import com.chulbul.hotelbooking.entity.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AmenitiesReqDto {
    private String name;
    private String description;

    private Hotel hotel;
}
