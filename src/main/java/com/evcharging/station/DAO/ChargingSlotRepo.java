package com.evcharging.station.DAO;

import com.evcharging.station.Entity.ChargingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingSlotRepo extends JpaRepository<ChargingSlot,String> {
}
