package com.evcharging.station.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChargingSlotDTO {
    private String slotId;
    private double pricePerHour;
    private String Status;
}
