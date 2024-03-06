package com.evcharging.station.Service;

import com.evcharging.station.DTO.ChargingStationDTO;

import java.util.List;

public interface ChargingStationService {
    ChargingStationDTO getChargingStationById(int chargingStationId);
    List<ChargingStationDTO> getAllChargingStation();
    ChargingStationDTO createChargingStation(ChargingStationDTO chargingStationDTO);
}
