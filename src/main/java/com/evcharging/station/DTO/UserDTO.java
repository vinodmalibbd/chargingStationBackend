package com.evcharging.station.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private  String emailId;
    private  String mobileNumber;
}
