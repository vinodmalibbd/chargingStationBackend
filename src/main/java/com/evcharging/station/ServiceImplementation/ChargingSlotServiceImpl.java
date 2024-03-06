package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.Service.ChargingSlotService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChargingSlotServiceImpl implements ChargingSlotService {
    @Override
    public ChargingSlotDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO) {
        return null;
    }

    @Override
    public ChargingSlotDTO changeAvailablity(int chargingSlotId) {
        return null;
    }

    @Override
    public ChargingSlotDTO getChargingSlotById(int chargingSlotId) {
        return null;
    }

    @Override
    public List<ChargingSlotDTO> getAllChargingSlotByChargingId(int chargingStationId) {
        return null;
    }
}
