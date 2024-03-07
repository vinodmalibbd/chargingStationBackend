package com.evcharging.station.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private  String emailId;
    private  String mobileNumber;
}
