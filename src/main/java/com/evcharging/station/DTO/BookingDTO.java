package com.evcharging.station.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private int bookingId;

    private Date date;
    private UserDTO user;
    private ChargingSlotDTO chargingSlot;
    private TimeSlotDTO timeSlot;
    @Column(nullable = false,length = 25)
    private String status;
}
