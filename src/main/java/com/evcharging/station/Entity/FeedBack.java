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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String feedbackId;

    private String feedback;
    private int rating;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private  User user;

}
