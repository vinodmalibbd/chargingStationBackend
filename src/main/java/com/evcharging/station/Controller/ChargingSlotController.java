package com.evcharging.station.Controller;

import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Service.ChargingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/chargingslot")
public class ChargingSlotController {
    @Autowired
    private ChargingSlotService chargingSlotService;

    @PostMapping("/addslot/{chargingStationId}")
    public ResponseEntity<ChargingStationDTO> createChargingSlot(@RequestBody ChargingSlotDTO chargingSlotDTO,@PathVariable String chargingStationId){
        ChargingStationDTO chargingStationDTO = chargingSlotService.addChargingSlot(chargingSlotDTO,chargingStationId);
        return  new ResponseEntity<>(chargingStationDTO, HttpStatusCode.valueOf(201));

    }

    @GetMapping("/{chargingSlotId}")
    public ResponseEntity<ChargingSlotDTO> getSlotById(@PathVariable String chargingSlotId){
        ChargingSlotDTO chargingSlotById = chargingSlotService.getChargingSlotById(chargingSlotId);
        return  new ResponseEntity<>(chargingSlotById,HttpStatusCode.valueOf(200));
    }
    @GetMapping("/all/{chargingStationId}")
    public  ResponseEntity<List<ChargingSlotDTO>> getAllSlotOfStation(@PathVariable String chargingStationId){
        List<ChargingSlotDTO> allChargingSlotByChargingId = chargingSlotService.getAllChargingSlotByChargingId(chargingStationId);
        return  new ResponseEntity<>(allChargingSlotByChargingId,HttpStatusCode.valueOf(200));
    }

}
