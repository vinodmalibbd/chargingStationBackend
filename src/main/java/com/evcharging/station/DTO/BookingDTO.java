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
    private int bookingId;
    private Date date;
    private int userId;
    private int chargingStationId;
    private int chargingSlotId;

}
