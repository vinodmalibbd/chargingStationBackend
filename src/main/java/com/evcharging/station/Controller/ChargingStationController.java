package com.evcharging.station.Controller;

import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Service.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chargingstation")
public class ChargingStationController {
    @Autowired
    private ChargingStationService chargingStationService;


    @PostMapping("/register")
    public ResponseEntity<ChargingStationDTO> registerChargingStation(@RequestBody ChargingStationDTO chargingStationDTO){
        ChargingStationDTO chargingStation = chargingStationService.createChargingStation(chargingStationDTO);
        return  new ResponseEntity<>(chargingStation, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{chargingStationId}")
    public  ResponseEntity<ChargingStationDTO> getChargingStation(@PathVariable String chargingStationId){
        ChargingStationDTO chargingStationById = chargingStationService.getChargingStationById(chargingStationId);
        return new ResponseEntity<>(chargingStationById,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public  ResponseEntity<List<ChargingStationDTO>> getAllChargingStation(){
        List<ChargingStationDTO> allChargingStation = chargingStationService.getAllChargingStation();
        return  new ResponseEntity<>(allChargingStation,HttpStatusCode.valueOf(200));

    }
}
