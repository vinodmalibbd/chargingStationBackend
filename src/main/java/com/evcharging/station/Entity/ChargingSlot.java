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
public class ChargingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String slotId;
    private double pricePerHour;
    private String Status;
}
