package com.evcharging.station.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
