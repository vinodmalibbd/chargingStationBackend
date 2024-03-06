package com.evcharging.station.Service;

import com.evcharging.station.DTO.ChargingSlotDTO;

import java.util.List;

public interface ChargingSlotService {
    ChargingSlotDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO);
    ChargingSlotDTO changeAvailablity(int chargingSlotId);
    ChargingSlotDTO getChargingSlotById(int chargingSlotId);
    List<ChargingSlotDTO> getAllChargingSlotByChargingId(int chargingStationId);

}
