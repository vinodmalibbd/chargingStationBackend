package com.evcharging.station.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;
    private String status;

    private Date date;

    private int timeslotId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chargingStationId")
    private ChargingStation chargingStation;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chargingSlotId")
    private ChargingSlot chargingSlot;


}
