package com.evcharging.station.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargingStationDTO {
    private String stationId;
    private String name;
    private double longitude;
    private double latitude;
}
