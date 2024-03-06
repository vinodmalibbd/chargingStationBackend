package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO getUserById(int id) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }
}
