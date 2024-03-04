package com.chulbul.hotelbooking.dto.res;

import com.chulbul.hotelbooking.entity.Hotel;
import com.chulbul.hotelbooking.entity.User;
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
public class ReviewDto {
    private long id;
    private double rating;
    private String comment;
    private Date date;

    private String userName;

}
