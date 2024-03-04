package com.chulbul.hotelbooking.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JwtRes {
    private String jwtToken;
    private String username;
    private List<String> roles;
}
