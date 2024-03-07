package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DAO.ChargingStationRepo;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Entity.ChargingStation;
import com.evcharging.station.Service.ChargingStationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChargingStationServiceImpl implements ChargingStationService {

    @Autowired
    private ChargingStationRepo chargingStationRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ChargingStationDTO getChargingStationById(String chargingStationId) {
        Optional<ChargingStation> isChargingStation = chargingStationRepo.findById(chargingStationId);
        if(isChargingStation.isEmpty()){
            System.out.println("station is not available");
            return  null;
        }
       return modelMapper.map(isChargingStation.get(),ChargingStationDTO.class);
    }

    @Override
    public List<ChargingStationDTO> getAllChargingStation() {
        List<ChargingStation> allChargingStation = chargingStationRepo.findAll();
        List<ChargingStationDTO> allChargingStationDTOs=new ArrayList<>();
        for (ChargingStation c:allChargingStation){
            allChargingStationDTOs.add(modelMapper.map(c,ChargingStationDTO.class));

        }
        return  allChargingStationDTOs;


    }

    @Override
    public ChargingStationDTO createChargingStation(ChargingStationDTO chargingStationDTO) {

        ChargingStation isExits = chargingStationRepo.findByEmailId(chargingStationDTO.getEmailId());
        if(isExits!=null){
            System.out.println("chargingstation already exits");
            return null;
        }
        ChargingStation chargingStation = modelMapper.map(chargingStationDTO, ChargingStation.class);
        ChargingStation saved = chargingStationRepo.save(chargingStation);
        return modelMapper.map(saved,ChargingStationDTO.class);

    }
}
