package com.evcharging.station.Controller;

import com.evcharging.station.DTO.ChargingSlotDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class ChargingSlotController {
    @PostMapping("/addslot")
    public ResponseEntity<ChargingSlotDTO> createCharging(@RequestBody ChargingSlotDTO chargingSlotDTO){
        return  new ResponseEntity<>(chargingSlotDTO, HttpStatusCode.valueOf(201));

    }
    @GetMapping("/getallslot")
    public  ResponseEntity<List<ChargingSlotDTO>> getAllChargingSlot(){
        return new ResponseEntity<>(new ArrayList<>(),HttpStatusCode.valueOf(200));
    }
}
