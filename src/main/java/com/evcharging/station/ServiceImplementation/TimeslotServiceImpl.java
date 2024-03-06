package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DTO.TimeSlotDTO;
import com.evcharging.station.Service.TimeslotService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimeslotServiceImpl implements TimeslotService {
    @Override
    public TimeSlotDTO createTimeSlot(TimeSlotDTO timeSlotDTO) {
        return null;
    }

    @Override
    public List<TimeSlotDTO> getAllTimeSlot() {
        return null;
    }

    @Override
    public List<TimeSlotDTO> availableTimingsChargingSlot(String slotId) {
        return null;
    }
}
