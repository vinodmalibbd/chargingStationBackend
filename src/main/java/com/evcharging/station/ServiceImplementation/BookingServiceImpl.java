package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.DAO.*;
import com.evcharging.station.DTO.BookingDTO;
import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.DTO.TimeSlotDTO;
import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.Entity.Booking;
import com.evcharging.station.Entity.ChargingSlot;
import com.evcharging.station.Entity.TimeSlot;
import com.evcharging.station.Entity.User;
import com.evcharging.station.Service.BookingService;
import com.evcharging.station.Templates.BookingRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ChargingSlotRepo chargingSlotRepo;

    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private TimeslotRepo timeslotRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookingDTO createBooking(BookingRequest bookingRequest) {
        Optional<TimeSlot> isTime = timeslotRepo.findById(bookingRequest.getTimeSlotId());
        Optional<ChargingSlot>isSlot = chargingSlotRepo.findById(bookingRequest.getChargingSlotId());


        Optional<User> isUser = userRepo.findById(bookingRequest.getUserId());
        if(isTime.isEmpty()||isUser.isEmpty()||isSlot.isEmpty()){
            System.out.println("something went wrong");
            return null;
        }
        Booking exitingBooking = bookingRepo.findByDateAndChargingSlotAndTimeSlot(bookingRequest.getDate(), isSlot.get(), isTime.get());
        if(exitingBooking!=null){
            System.out.println("you can't book");
            System.out.println(exitingBooking.toString());
            return null;
        }
        Booking b=new Booking();
        b.setUser(isUser.get());
        b.setChargingSlot(isSlot.get());
        b.setTimeSlot(isTime.get());
        b.setDate(bookingRequest.getDate());
        b.setStatus("confirmed");
        Booking save = bookingRepo.save(b);

        BookingDTO bdto=new BookingDTO();



        bdto.setUser(modelMapper.map(save.getUser(), UserDTO.class));
        bdto.setChargingSlot(modelMapper.map(save.getChargingSlot(), ChargingSlotDTO.class));
        bdto.setDate(save.getDate());
        bdto.setTimeSlot(modelMapper.map(save.getTimeSlot(), TimeSlotDTO.class));
        bdto.setStatus(save.getStatus());

        return bdto;
    }

    @Override
    public List<BookingDTO> getAllChargingStationBooking(int ChargingStationId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingSlotBooking(int ChargingSlotId) {

        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(ChargingSlotId);
        if(isSlot.isEmpty()) {
            System.out.println("slot is not available");
            return null;
        }

        List<Booking> allByChargingSlotAndDate = bookingRepo.findAllByChargingSlot(isSlot.get());
        List<BookingDTO> bookingDTOS=new ArrayList<>();
        for (Booking b: allByChargingSlotAndDate){
            bookingDTOS.add(modelMapper.map(b, BookingDTO.class));
        }
        return bookingDTOS;
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
