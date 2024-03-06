package com.evcharging.station.Controller;


import com.evcharging.station.DTO.BookingDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")

public class BookingController {
    @PostMapping("/create")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO){
        return new ResponseEntity<>(bookingDTO, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/chargingstation/{stationId}")
    public  ResponseEntity<List<BookingDTO>>getStationBookingTodays(){
        return new ResponseEntity<>(new ArrayList<>(),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<List<BookingDTO>> getUserBookingTodays(){
        return new ResponseEntity<>(new ArrayList<>(),HttpStatusCode.valueOf(200));
    }
    @PutMapping("/cancle/{bookingId}")
    public ResponseEntity<BookingDTO> cancleBooking(){
        return new ResponseEntity<>(new BookingDTO(), HttpStatusCode.valueOf(201));
    }
}
