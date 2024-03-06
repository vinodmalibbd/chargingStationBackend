package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DTO.BookingDTO;
import com.evcharging.station.Service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingStationBooking(String ChargingStationId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingSlotBooking(String ChargingSlotId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingSlotBookingByDate(String ChargingSlotId, Date date) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingStationBookingByDate(String ChargingStationId, Date date) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllUserBooking(String userId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllUserBookingByDate(String userId, Date date) {
        return null;
    }
}
