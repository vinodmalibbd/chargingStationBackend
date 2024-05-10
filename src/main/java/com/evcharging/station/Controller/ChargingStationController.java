package com.evcharging.station.Controller;

import com.evcharging.station.Config.TokenGenerator;
import com.evcharging.station.DTO.ChargingStationDTO;
import com.evcharging.station.Service.ChargingStationService;
import com.evcharging.station.Templates.ResponseTemplate;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private TokenGenerator tokenGenerator;
    @PutMapping("/update")
    public ResponseEntity<ChargingStationDTO> registerChargingStation(@RequestBody ChargingStationDTO chargingStationDTO , HttpServletRequest request){
        String token = request.getHeader("Authorization");
        ChargingStationDTO chargingStation = chargingStationService.updateChargingStation(chargingStationDTO);
        return  new ResponseEntity<>(chargingStation, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{chargingStationId}")
    public  ResponseEntity<ChargingStationDTO> getChargingStation(@PathVariable int chargingStationId){
        ChargingStationDTO chargingStationById = chargingStationService.getChargingStationById(chargingStationId);
        return new ResponseEntity<>(chargingStationById,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/all")
    public  ResponseEntity<List<ChargingStationDTO>> getAllChargingStation( HttpServletRequest request){
        String token = request.getHeader("Authorization");
        boolean validToken = tokenGenerator.isValidToken(token);
        System.out.println(validToken);
        System.out.println(token);
        List<ChargingStationDTO> allChargingStation = chargingStationService.getAllChargingStation();
        return  new ResponseEntity<>(allChargingStation,HttpStatusCode.valueOf(200));

    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<ResponseTemplate> deleteSlot(@PathVariable int Id){
        ResponseTemplate responseTemplate = chargingStationService.deleteChargingStation(Id);
        return new ResponseEntity<>(responseTemplate,HttpStatusCode.valueOf(200));
    }

}
