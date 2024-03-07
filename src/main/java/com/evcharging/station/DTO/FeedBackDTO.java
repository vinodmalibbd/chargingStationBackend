package com.evcharging.station.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDTO {
    private String feedbackId;

    private String feedback;
    private int rating;
    private String userId;
    private String chargingStationId;
}
