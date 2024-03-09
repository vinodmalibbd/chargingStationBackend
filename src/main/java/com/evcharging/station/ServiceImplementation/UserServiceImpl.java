package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DAO.UserRepo;
import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.Entity.User;
import com.evcharging.station.RuntimeException.ResourceAlreadyExist;
import com.evcharging.station.RuntimeException.ResourceNotFound;
import com.evcharging.station.Service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO getUserById(int userId) {
        Optional<User> isUser = userRepo.findById(userId);
        if(isUser.isEmpty()){
            System.out.println("user is not available");
            throw new ResourceNotFound("user","not available");
        }
        User user = isUser.get();
         return  modelMapper.map(user,UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User byEmailId = userRepo.findByEmailId(userDTO.getEmailId());
        if(byEmailId!=null){
            System.out.println("user already exits");
            throw new ResourceAlreadyExist("user","already Exist");
        }
        User mappedUser = modelMapper.map(userDTO, User.class);
        User savedUser = userRepo.save(mappedUser);
        return modelMapper.map(savedUser,UserDTO.class);

    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> allUser = userRepo.findAll();
        List<UserDTO>  allUserDTOs=new ArrayList<>();
        for(User u:allUser){
            allUserDTOs.add(modelMapper.map(u,UserDTO.class));
        }
        return allUserDTOs;
    }
}
