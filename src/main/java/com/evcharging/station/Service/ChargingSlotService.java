package com.evcharging.station.Service;

import com.evcharging.station.DTO.ChargingSlotDTO;

import java.util.List;
import java.util.Set;

public interface ChargingSlotService {
    ChargingSlotDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO);
    ChargingSlotDTO changeAvailablity(String chargingSlotId);
    ChargingSlotDTO getChargingSlotById(String chargingSlotId);
    Set<ChargingSlotDTO> getAllChargingSlotByChargingId(String chargingStationId);

}
