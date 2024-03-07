package com.evcharging.station.Service;

import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Entity.ChargingStation;

import java.util.List;
import java.util.Set;

public interface ChargingSlotService {
    ChargingStationDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO,int chargingStationId);



    ChargingSlotDTO changeAvailablity(int chargingSlotId);
    ChargingSlotDTO getChargingSlotById(int chargingSlotId);
    List<ChargingSlotDTO> getAllChargingSlotByChargingId(int chargingStationId);

}
