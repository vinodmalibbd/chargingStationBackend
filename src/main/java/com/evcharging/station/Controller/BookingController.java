package com.evcharging.station.Controller;


import com.evcharging.station.DTO.BookingDTO;
import com.evcharging.station.Service.BookingService;
import com.evcharging.station.Templates.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")

public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/create")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingRequest bookingRequest){
        BookingDTO booking = bookingService.createBooking(bookingRequest);
        return new ResponseEntity<>(booking, HttpStatusCode.valueOf(201));
    }
    @GetMapping("/all/chargingslot/{chargingslotid}")
    public  ResponseEntity<List<BookingDTO>> getAllBookingsforSlot(@PathVariable int chargingslotid){
        List<BookingDTO> allChargingSlotBooking = bookingService.getAllChargingSlotBooking(chargingslotid);

        return new ResponseEntity<>(allChargingSlotBooking,HttpStatusCode.valueOf(200));
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
