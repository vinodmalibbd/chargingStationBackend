package com.evcharging.station.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackDTO {
    private String feedbackId;

    private String feedback;
    private int rating;
}
