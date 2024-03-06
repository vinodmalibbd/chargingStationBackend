package com.evcharging.station.Service;

import com.evcharging.station.DTO.BookingDTO;

import java.util.Date;
import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);
    List<BookingDTO> getAllChargingStationBooking(String ChargingStationId);
    List<BookingDTO> getAllChargingSlotBooking(String ChargingSlotId);
    List<BookingDTO> getAllChargingSlotBookingByDate(String ChargingSlotId, Date date);
    List<BookingDTO> getAllChargingStationBookingByDate(String ChargingStationId, Date date);

    List<BookingDTO> getAllUserBooking(String userId);
    List<BookingDTO> getAllUserBookingByDate(String userId,Date date);



}
