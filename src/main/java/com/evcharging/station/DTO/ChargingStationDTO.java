package com.evcharging.station.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStationDTO {
    private String stationId;

    private String name;
    private double longitude;
    private double latitude;
    private String emailId;
}
