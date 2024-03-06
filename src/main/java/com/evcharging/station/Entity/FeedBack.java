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
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String feedbackId;

    private String feedback;
    private int rating;
}
