package com.evcharging.station.DAO;

import com.evcharging.station.Entity.Booking;
import com.evcharging.station.Entity.ChargingSlot;
import com.evcharging.station.Entity.ChargingStation;
import com.evcharging.station.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findAllByChargingStation(ChargingStation chargingStation);
    List<Booking> findAllByUser(User user);
    List<Booking> findAllByChargingSlotAndDate(ChargingSlot chargingSlot, Date date);
    List<Booking> findAllByChargingSlotAndDateAndTimeslotId(ChargingSlot chargingSlot, Date date,int timeslotId);
}
