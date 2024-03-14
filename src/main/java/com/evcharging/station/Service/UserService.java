package com.evcharging.station.Service;

import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.Templates.ResponseTemplate;

import java.util.List;

public interface UserService {
    UserDTO getUserById(int userId);
    UserDTO createUser(UserDTO user);
    List<UserDTO> getAllUser();
    ResponseTemplate deleteUser(int Id);

}
