package com.evcharging.station.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ChargingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String slotId;
    private double pricePerHour;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "chargingStation")
    @JsonIgnore
    private  ChargingStation chargingStation;
}
