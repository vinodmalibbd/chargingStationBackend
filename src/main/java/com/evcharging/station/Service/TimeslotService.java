package com.evcharging.station.Service;

import com.evcharging.station.DTO.TimeSlotDTO;

import java.util.List;

public interface TimeslotService {
    TimeSlotDTO createTimeSlot(TimeSlotDTO timeSlotDTO);
    List<TimeSlotDTO> getAllTimeSlot();
    List<TimeSlotDTO> availableTimingsChargingSlot(String slotId);

}
