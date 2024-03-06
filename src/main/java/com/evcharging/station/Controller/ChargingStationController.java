package com.evcharging.station.Controller;

import com.evcharging.station.DTO.ChargingStationDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


public class ChargingStationController {
    @PostMapping("/register")
    public ResponseEntity<ChargingStationDTO> registerChargingStation(@RequestBody ChargingStationDTO chargingStationDTO){
        return  new ResponseEntity<>(chargingStationDTO, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{stationId}")
    public  ResponseEntity<ChargingStationDTO> getChargingStation(@PathVariable int stationId){
        return new ResponseEntity<>(new ChargingStationDTO(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public  ResponseEntity<List<ChargingStationDTO>> getAllChargingStation(){
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatusCode.valueOf(200));

    }
}
