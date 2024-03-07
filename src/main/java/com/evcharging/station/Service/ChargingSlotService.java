package com.evcharging.station.Service;

import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Entity.ChargingStation;

import java.util.List;
import java.util.Set;

public interface ChargingSlotService {
    ChargingStationDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO,String chargingStationId);
    ChargingSlotDTO changeAvailablity(String chargingSlotId);
    ChargingSlotDTO getChargingSlotById(String chargingSlotId);
    List<ChargingSlotDTO> getAllChargingSlotByChargingId(String chargingStationId);

}
