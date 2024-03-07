package com.evcharging.station.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChargingSlotDTO {
    private String slotId;
    private double pricePerHour;
    private String Status;
    private String chargingStationId;
}
