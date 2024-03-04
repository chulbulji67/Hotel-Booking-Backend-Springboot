package com.chulbul.hotelbooking.dto.req;

import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.User;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReviewReqDto {
    private double rating;
    private String comment;
    private Date date;

    private Hotel hotel;

    private User user;
}
