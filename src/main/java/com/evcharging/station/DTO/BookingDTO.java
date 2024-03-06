package com.evcharging.station.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class BookingDTO {
    private String bookingId;
    private String status;
    private Date date;
    private int timeslotId;
}
