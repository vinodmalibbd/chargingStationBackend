package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DAO.ChargingSlotRepo;
import com.evcharging.station.DAO.ChargingStationRepo;
import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Entity.ChargingSlot;
import com.evcharging.station.Entity.ChargingStation;
import com.evcharging.station.Service.ChargingSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChargingSlotServiceImpl implements ChargingSlotService {

    @Autowired
    private ChargingSlotRepo chargingSlotRepo;
    @Autowired
    private ChargingStationRepo chargingStationRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ChargingStationDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO, String chargingStationId) {
        Optional<ChargingStation> isChargingStation = chargingStationRepo.findById(chargingStationId);
        if(isChargingStation.isEmpty()){
            System.out.println("can't add slot due to station is not exits");
            return null;
        }
        ChargingStation chargingStation = isChargingStation.get();
        List<ChargingSlot> slots=chargingStation.getChargingSlots();
        ChargingSlot slot = modelMapper.map(chargingSlotDTO, ChargingSlot.class);
        slot.setChargingStation(chargingStation);
        slots.add(slot);
        chargingStation.setChargingSlots(slots);
        ChargingStation savedChargingStation = chargingStationRepo.save(chargingStation);
        List<ChargingSlot> chargingSlots = savedChargingStation.getChargingSlots();
        List<ChargingSlotDTO> dtos=new ArrayList<>();
        for(ChargingSlot s:chargingSlots){
            dtos.add(modelMapper.map(s,ChargingSlotDTO.class));
        }


        ChargingStationDTO mappedDTOs = modelMapper.map(savedChargingStation, ChargingStationDTO.class);
        mappedDTOs.setChargingSlotDTOS(dtos);
        return  mappedDTOs;
    }





    @Override
    public ChargingSlotDTO changeAvailablity(String chargingSlotId) {
        return null;
    }

    @Override
    public ChargingSlotDTO getChargingSlotById(String chargingSlotId) {
        Optional<ChargingSlot> slotbyId = chargingSlotRepo.findById(chargingSlotId);
        if(slotbyId.isEmpty()){
            System.out.println("charging slot is not exits");
            return null;
        }
        ChargingSlot chargingSlot = slotbyId.get();
        ChargingStation chargingStation = chargingSlot.getChargingStation();

        ChargingSlotDTO map = modelMapper.map(chargingSlot, ChargingSlotDTO.class);
        map.setChargingStationDTO(modelMapper.map(chargingStation,ChargingStationDTO.class));

        return map;
    }

    @Override
    public List<ChargingSlotDTO> getAllChargingSlotByChargingId(String chargingStationId) {
        Optional<ChargingStation> byId = chargingStationRepo.findById(chargingStationId);
        if(byId.isEmpty()){
            System.out.println("station is not present");
            return  null;
        }

        ChargingStation chargingStation = byId.get();

        List<ChargingSlotDTO> chargingSlotDTOS=new ArrayList<>();
        List<ChargingSlot> chargingSlots = chargingStation.getChargingSlots();

        for (ChargingSlot chargingSlot : chargingSlots) {
            chargingSlotDTOS.add(modelMapper.map(chargingSlot,ChargingSlotDTO.class));
        }

        return chargingSlotDTOS;
    }


}
