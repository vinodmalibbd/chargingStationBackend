package com.evcharging.station.Service.impl;

import com.evcharging.station.DAO.ChargingStationRepo;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Templates.ResponseTemplate;
import com.evcharging.station.domain.ChargingStation;
import com.evcharging.station.RuntimeException.ResourceAlreadyExist;
import com.evcharging.station.RuntimeException.ResourceNotFound;
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
    public ChargingStationDTO getChargingStationById(int chargingStationId) {
        Optional<ChargingStation> isChargingStation = chargingStationRepo.findById(chargingStationId);
        if(isChargingStation.isEmpty()){
            System.out.println("station is not available");
            throw new ResourceNotFound("Station","not found, try again");
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
           // System.out.println("chargingstation already exits");
            throw new ResourceAlreadyExist("station","already exist");

        }

        ChargingStation chargingStation = modelMapper.map(chargingStationDTO, ChargingStation.class);
        ChargingStation saved = chargingStationRepo.save(chargingStation);
        return modelMapper.map(saved,ChargingStationDTO.class);

    }

    @Override
    public ResponseTemplate deleteChargingStation(int id) {
        Optional<ChargingStation>byid=chargingStationRepo.findById(id);
        if(byid.isEmpty()){
            throw  new ResourceNotFound("charging station","not found");
        }
        chargingStationRepo.delete(byid.get());
        return new ResponseTemplate("charging slot deleted",true);
    }
}
