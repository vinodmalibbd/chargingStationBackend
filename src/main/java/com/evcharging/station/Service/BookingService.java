package com.evcharging.station.Service;

import com.evcharging.station.DTO.BookingDTO;

import java.util.Date;
import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);
    List<BookingDTO> getAllChargingStationBooking(int ChargingStationId);
    List<BookingDTO> getAllChargingSlotBooking(int ChargingSlotId);
    List<BookingDTO> getAllChargingSlotBookingByDate(int ChargingSlotId, Date date);
    List<BookingDTO> getAllChargingStationBookingByDate(int ChargingStationId, Date date);

    List<BookingDTO> getAllUserBooking(int userId);
    List<BookingDTO> getAllUserBookingByDate(int userId,Date date);



}
