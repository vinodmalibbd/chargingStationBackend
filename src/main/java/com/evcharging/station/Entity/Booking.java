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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String status;

    @Temporal(TemporalType.DATE)
    private Date date;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chargingSlotId")
    private ChargingSlot chargingSlot;

    private int timeSlotId;


}
