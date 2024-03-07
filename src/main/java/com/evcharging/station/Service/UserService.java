package com.evcharging.station.Service;

import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.Entity.User;

import java.util.List;

public interface UserService {
    UserDTO getUserById(String userId);
    UserDTO createUser(UserDTO user);
    List<UserDTO> getAllUser();

}
