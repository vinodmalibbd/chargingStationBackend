package com.evcharging.station.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    private String feedback;
    private int rating;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private  User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chargingStationId")
    private ChargingStation chargingStation;

}