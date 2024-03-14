package com.evcharging.station;

import com.evcharging.station.DAO.ChargingStationRepo;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.RuntimeException.ResourceAlreadyExist;
import com.evcharging.station.Service.impl.ChargingStationServiceImpl;
import com.evcharging.station.domain.ChargingStation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChargingStationServiceImplTest {
    @Mock
    private ChargingStationRepo chargingStationRepo;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private ChargingStationServiceImpl chargingStationService;
    @Test
    public void createStation(){
        ChargingStationDTO chargingStationDTO=new ChargingStationDTO();
        chargingStationDTO.setEmailId("example@gmail.com");

        ChargingStation chargingStation=new ChargingStation();
        chargingStation.setEmailId("example@gmail.com");

        when(chargingStationRepo.findByEmailId("example@gmail.com")).thenReturn(null);
        when(modelMapper.map(chargingStationDTO,ChargingStation.class)).thenReturn(chargingStation);
        when(chargingStationRepo.save(chargingStation)).thenReturn(chargingStation);
        when(modelMapper.map(chargingStation,ChargingStationDTO.class)).thenReturn(chargingStationDTO);

        ChargingStationDTO result=chargingStationService.createChargingStation(chargingStationDTO);
        assertNotNull(result);
        assertEquals(chargingStationDTO.getEmailId(),result.getEmailId());
    }
    @Test
    public void chargingStationAlreadyExist(){
        ChargingStationDTO chargingStationDTO=new ChargingStationDTO();
        chargingStationDTO.setEmailId("example@gmail.com");
        ChargingStation existingChargingStation=new ChargingStation();
        existingChargingStation.setEmailId("example@gmail.com");
        when(chargingStationRepo.findByEmailId("example@gmail.com")).thenReturn(existingChargingStation);
        assertThrows(ResourceAlreadyExist.class,()->chargingStationService.createChargingStation(chargingStationDTO));

    }

}
