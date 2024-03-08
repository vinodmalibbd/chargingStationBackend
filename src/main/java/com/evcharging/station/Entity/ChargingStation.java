package com.evcharging.station.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationId;

    private String name;
    private double longitude;
    private double latitude;
    private String emailId;
    private int openTime;
    private int closeTime;
    @OneToMany(mappedBy = "chargingStation",cascade = CascadeType.ALL)
    private List<ChargingSlot> chargingSlots=new ArrayList<>();
//    @OneToMany(mappedBy = "chargingStation" ,cascade = CascadeType.ALL)
//    private List<Booking> stationBookigs=new ArrayList<>();
    @OneToMany(mappedBy = "chargingStation" ,cascade = CascadeType.ALL)
    private List<FeedBack> feedbacks=new ArrayList<>();
}
