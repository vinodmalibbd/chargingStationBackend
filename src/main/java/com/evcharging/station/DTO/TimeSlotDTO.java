package com.evcharging.station.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeSlotDTO {
    private int stationId;
    private int startTime;
    private int endTime;

}
