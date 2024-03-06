package com.evcharging.station.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(nullable = false,length = 25,name = "FirstName")
    private String firstName;
    @Column(nullable = false,length = 25,name = "LastName")
    private String lastName;
    @Column(nullable = false,length = 25,unique = true,name = "Email")
    private  String emailId;
    @Column(nullable = false,length = 15,name ="MobileNumber")
    private  String mobileNumber;
}
