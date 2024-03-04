package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.dto.JwtReq;
import com.chulbul.hotelbooking.dto.JwtRes;
import com.chulbul.hotelbooking.service.userservice.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JwtRes> login(@RequestBody JwtReq request) {
        System.out.println("Working");
        return ResponseEntity.status(HttpStatus.OK).body( authService.authService(request));
    }





}
