package com.evcharging.station.Controller;

import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;




@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId){
        UserDTO user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatusCode.valueOf(201));
    }
}
