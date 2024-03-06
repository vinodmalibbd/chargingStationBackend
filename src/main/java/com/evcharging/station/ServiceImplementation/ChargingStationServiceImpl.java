package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Service.ChargingStationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChargingStationServiceImpl implements ChargingStationService {
    @Override
    public ChargingStationDTO getChargingStationById(int chargingStationId) {
        return null;
    }

    @Override
    public List<ChargingStationDTO> getAllChargingStation() {
        return null;
    }

    @Override
    public ChargingStationDTO createChargingStation(ChargingStationDTO chargingStationDTO) {
        return null;
    }
}
