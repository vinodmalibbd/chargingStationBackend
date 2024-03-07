package com.evcharging.station.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String bookingId;
    private Date date;
    private String userId;
    private String chargingStationId;
    private String chargingSlotId;

}
