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
    public List<BookingDTO> getAllChargingStationBooking(int ChargingStationId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingSlotBooking(int ChargingSlotId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingSlotBookingByDate(int ChargingSlotId, Date date) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingStationBookingByDate(int ChargingStationId, Date date) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllUserBooking(int userId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllUserBookingByDate(int userId, Date date) {
        return null;
    }
}
