package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DAO.ChargingSlotRepo;
import com.evcharging.station.DAO.ChargingStationRepo;
import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.Entity.ChargingSlot;
import com.evcharging.station.Entity.ChargingStation;
import com.evcharging.station.Service.ChargingSlotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ChargingSlotServiceImpl implements ChargingSlotService {

    @Autowired
    private ChargingSlotRepo chargingSlotRepo;
    @Autowired
    private ChargingStationRepo chargingStationRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ChargingSlotDTO addChargingSlot(ChargingSlotDTO chargingSlotDTO) {
        Optional<ChargingStation> isChargingStation = chargingStationRepo.findById(chargingSlotDTO.getChargingStationId());
        if(isChargingStation.isEmpty()){
            System.out.println("can't add slot due to station is not exits");
            return null;
        }
        ChargingStation chargingStation = isChargingStation.get();
        Set<ChargingSlot> chargingSlots = chargingStation.getChargingSlots();
        if(chargingSlots.contains(modelMapper.map(chargingSlotDTO,ChargingSlot.class))){
            System.out.println("can't add slot due to slot already exits");
            return null;
        }
        chargingSlots.add(modelMapper.map(chargingSlotDTO, ChargingSlot.class));
        chargingStation.setChargingSlots(chargingSlots);
        ChargingStation savedChargingStation = chargingStationRepo.save(chargingStation);
        return chargingSlotDTO;

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
        return  modelMapper.map(chargingSlot,ChargingSlotDTO.class);

    }

    @Override
    public Set<ChargingSlotDTO> getAllChargingSlotByChargingId(String chargingStationId) {
        Optional<ChargingStation> isChargingStation = chargingStationRepo.findById(chargingStationId);
        if(isChargingStation.isEmpty()){
            System.out.println("charging station is not available");
            return  null;
        }
        ChargingStation chargingStation = isChargingStation.get();
        Set<ChargingSlot> chargingSlots = chargingStation.getChargingSlots();
        Set<ChargingSlotDTO> chargingSlotDTOS=new HashSet<>();
        for (ChargingSlot s:chargingSlots){
            chargingSlotDTOS.add(modelMapper.map(s,ChargingSlotDTO.class));
        }
        return  chargingSlotDTOS;
    }
}
