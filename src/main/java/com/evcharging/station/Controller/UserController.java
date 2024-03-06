package com.evcharging.station.Controller;

import com.evcharging.station.DTO.UserDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId){
        return new ResponseEntity<>(new UserDTO(), HttpStatusCode.valueOf(201));
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return new ResponseEntity<>(new ArrayList<>(), HttpStatusCode.valueOf(201));
    }
}
