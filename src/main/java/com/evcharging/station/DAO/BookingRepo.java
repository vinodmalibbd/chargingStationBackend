package com.evcharging.station.DAO;

import com.evcharging.station.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

    Booking findByDateAndChargingSlotAndTimeSlot(Date date, ChargingSlot chargingSlot, TimeSlot timeSlot);
    List<Booking> findAllByUser(User user);
    List<Booking> findAllByChargingSlotAndDate(ChargingSlot chargingSlot, Date date);
    List<Booking> findAllByChargingSlot(ChargingSlot chargingSlot);

}
