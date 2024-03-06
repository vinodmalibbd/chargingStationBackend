package com.evcharging.station.Controller;

import com.evcharging.station.DTO.FeedBackDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class FeedBackController {
    @PostMapping("/addfeedback/{stationID}")
    public ResponseEntity<FeedBackDTO> addFeedbackOnStation(@RequestBody FeedBackDTO feedBackDTO){
        return new ResponseEntity<>(feedBackDTO, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/allfeedback/{stationId}")
    public  ResponseEntity<List<FeedBackDTO>> getAllFeedBackStation(@PathVariable int stationId){
        return new ResponseEntity<>(new ArrayList<>(),HttpStatusCode.valueOf(200));
    }
}
