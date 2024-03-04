package com.chulbul.hotelbooking.controller;

import com.chulbul.hotelbooking.entity.User;
import com.chulbul.hotelbooking.service.userservice.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> regiserUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUsre(user));
    }
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserById(@PathVariable long id){
        log.info("Delete Controller");
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteByUserId(id));
    }

}
