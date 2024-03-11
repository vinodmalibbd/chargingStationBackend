package com.evcharging.station.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationId;
    @Column(nullable = false,length = 25,name = "StationName")
    private String name;
    @Column(nullable = false,name = "Longitude")
    private double longitude;
    @Column(nullable = false,name = "Latitude")
    private double latitude;
    @Column(nullable = false,length = 25,name = "EmailId",unique = true)
    private String emailId;
    @Column(nullable = false,name = "OpenTime")
    private int openTime;
    @Column(nullable = false,name = "CloseTime")
    private int closeTime;
    @OneToMany(mappedBy = "chargingStation",cascade = CascadeType.ALL)
    private List<ChargingSlot> chargingSlots=new ArrayList<>();
//    @OneToMany(mappedBy = "chargingStation" ,cascade = CascadeType.ALL)
//    private List<Booking> stationBookigs=new ArrayList<>();
    @OneToMany(mappedBy = "chargingStation" ,cascade = CascadeType.ALL)
    private List<FeedBack> feedbacks=new ArrayList<>();
}
