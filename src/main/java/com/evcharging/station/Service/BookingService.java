package com.evcharging.station.Service;

import com.evcharging.station.DTO.BookingDTO;
import com.evcharging.station.DTO.TimeSlotDTO;
import com.evcharging.station.Entity.TimeSlot;
import com.evcharging.station.Templates.BookingRequest;

import java.util.Date;
import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingRequest bookingDetails);
    List<BookingDTO> getAllChargingStationBooking(int ChargingStationId);
    List<BookingDTO> getAllChargingSlotBooking(int ChargingSlotId);
    List<BookingDTO> getAllChargingSlotBookingByDate(int ChargingSlotId, Date date);
    List<BookingDTO> getAllChargingStationBookingByDate(int ChargingStationId, Date date);


    List<BookingDTO> getAllUserBooking(int userId);
    List<BookingDTO> getAllUserBookingByDate(int userId,Date date);

    String cancleBooking(int bookingId);
    List<TimeSlotDTO> getBookedTimeslot(int chargingSlotId);
    List<TimeSlot> getAvailableTimeslot(int chargingSlotId);


}
