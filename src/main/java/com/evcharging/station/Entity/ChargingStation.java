package com.evcharging.station.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String stationId;

    private String name;
    private double longitude;
    private double latitude;
    private String email;
    private int openTime;
    private int closeTime;
    @OneToMany(mappedBy = "chargingStation",cascade = CascadeType.ALL)
    private Set<ChargingSlot> chargingSlots=new HashSet<>();
    @OneToMany(mappedBy = "chargingStation" ,cascade = CascadeType.ALL)
    private List<Booking> stationBookigs=new ArrayList<>();
}
