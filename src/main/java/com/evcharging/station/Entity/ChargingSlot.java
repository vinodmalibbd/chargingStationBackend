package com.evcharging.station.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChargingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String slotId;
    private double pricePerHour;
    private boolean available;
    @ManyToOne
    @JoinColumn(name = "chargingStation")
    @JsonIgnore
    private  ChargingStation chargingStation;
}
