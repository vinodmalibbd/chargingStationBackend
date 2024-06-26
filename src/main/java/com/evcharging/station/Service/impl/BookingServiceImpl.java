package com.evcharging.station.Service.impl;

import com.evcharging.station.DAO.*;
import com.evcharging.station.DTO.BookingDTO;
import com.evcharging.station.DTO.ChargingSlotDTO;
import com.evcharging.station.DTO.TimeSlotDTO;
import com.evcharging.station.DTO.UserDTO;
import com.evcharging.station.domain.*;
import com.evcharging.station.RuntimeException.ResourceAlreadyExist;
import com.evcharging.station.RuntimeException.ResourceNotFound;
import com.evcharging.station.Service.BookingService;
import com.evcharging.station.Templates.BookingRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
//        System.out.println(isTime.get().getTimeSlotId());
//        System.out.println(isSlot.get().getSlotId());
//        System.out.println(isUser.get().getUserId());

        if(isTime.isEmpty()||isUser.isEmpty()||isSlot.isEmpty()){
            throw new ResourceNotFound(" ","All Fields are required ,fill all fields");
        }
        Booking exitingBooking = bookingRepo.findByDateAndChargingSlotAndTimeSlotIdAndStatus(bookingRequest.getDate(), isSlot.get(), bookingRequest.getTimeSlotId(),"confirmed");
        if(exitingBooking!=null ) {
            throw new ResourceAlreadyExist("slot", "is already Occupied");
        }
        int openTime = isSlot.get().getChargingStation().getOpenTime();
        int closeTime = isSlot.get().getChargingStation().getCloseTime();
        int timeSlotId = isTime.get().getTimeSlotId();

        if(openTime<timeSlotId && timeSlotId<=closeTime) {

            Booking b = new Booking();
            b.setUser(isUser.get());
            b.setChargingSlot(isSlot.get());
            b.setTimeSlotId(bookingRequest.getTimeSlotId());
            b.setDate(bookingRequest.getDate());
            b.setStatus("confirmed");
            Booking save = bookingRepo.save(b);
            BookingDTO bdto = new BookingDTO();
            bdto.setBookingId(save.getBookingId());
            bdto.setUser(modelMapper.map(save.getUser(), UserDTO.class));
            bdto.setChargingSlot(modelMapper.map(save.getChargingSlot(), ChargingSlotDTO.class));
            bdto.setDate(save.getDate());
            bdto.setTimeSlot(modelMapper.map(isTime.get(), TimeSlotDTO.class));
            bdto.setStatus(save.getStatus());
            return bdto;
        }
        else{
            throw new ResourceNotFound("TimeSlot","is not in the working hours");
        }
    }

    @Override
    public List<BookingDTO> getAllChargingStationBooking(int ChargingStationId) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllChargingSlotBooking(int ChargingSlotId) {

        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(ChargingSlotId);
        if(isSlot.isEmpty()) {
            throw new ResourceNotFound("slot"," is not Available");
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

        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(ChargingSlotId);
        if (isSlot.isEmpty()){
            throw new ResourceNotFound("slot", "is not found");
        }
        List<Booking> allByChargingSlotAndDate = bookingRepo.findAllByChargingSlotAndDate(isSlot.get(), date);
        List<BookingDTO> ls=new ArrayList<>();
        for (Booking b:allByChargingSlotAndDate){
            ls.add(modelMapper.map(b,BookingDTO.class));
        }
        return ls;
    }

    @Override
    public List<BookingDTO> getAllChargingStationBookingByDate(int ChargingStationId, Date date) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllUserBooking(int userId) {
        Optional<User> isUser = userRepo.findById(userId);
        if(isUser.isEmpty()){
            throw new ResourceNotFound("user","not found, try again");
        }
        List<Booking> allByUser = bookingRepo.findAllByUser(isUser.get());
        List<BookingDTO> ls=new ArrayList<>();
        for (Booking b: allByUser){
            ls.add(modelMapper.map(b,BookingDTO.class));
        }
        return ls;
    }

    @Override
    public List<BookingDTO> getAllUserBookingByDate(int userId, Date date) {
        Optional<User> isUser = userRepo.findById(userId);
        if(isUser.isEmpty()){
            throw new ResourceNotFound("user","not found, try again");
        }
        List<Booking> allByUserAndDate = bookingRepo.findAllByUserAndDate(isUser.get(), date);
        List<BookingDTO> ls=new ArrayList<>();
        for (Booking b: allByUserAndDate){
            ls.add(modelMapper.map(b,BookingDTO.class));
        }
        return ls;
    }

    @Override
    public String cancleBooking(int bookingId) {
        Optional<Booking> isBooking = bookingRepo.findById(bookingId);
        if(isBooking.isEmpty()){
            throw new ResourceNotFound("booking","not available");
        }
        Booking booking = isBooking.get();
        Date todayDate=new Date();
        int timeSlotId = booking.getTimeSlotId();

        Optional<TimeSlot> isTime = timeslotRepo.findById(timeSlotId);
        if(isTime.isEmpty()){
            throw new ResourceNotFound("timeSlot"," not Available");
        }

        if(booking.getDate().compareTo(todayDate)>0){
            booking.setStatus("cancled");
             bookingRepo.save(booking);
            System.out.println("cancled future booking");
            return booking.getStatus();

        } else if (booking.getDate().compareTo(todayDate)==0) {
//            TimeSlot timeSlot = isTime.get();

            if(todayDate.getHours()<isTime.get().getStartTime()){
                booking.setStatus("cancled");
                bookingRepo.save(booking);
                System.out.println("cancle todays booking");
                return  booking.toString();
            }

        }
        return "you can't cancel the booking";

    }

    @Override
    public List<TimeSlotDTO> getBookedTimeslot(int chargingSlotId) {
        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(chargingSlotId);
        if(isSlot.isEmpty()){
            System.out.println("slot is not present");
            return  null;
        }
        List<Booking> allByChargingSlot = bookingRepo.findAllByChargingSlot(isSlot.get());
        List<TimeSlot> alltimeslot = timeslotRepo.findAll();


        List<TimeSlotDTO>ls =new ArrayList<>();
        for (Booking b:allByChargingSlot){
            Optional<TimeSlot> isTime = timeslotRepo.findById(b.getTimeSlotId());

            if(alltimeslot.contains(isTime.get())){
                ls.add(modelMapper.map(isTime.get(),TimeSlotDTO.class));
            }
        }
        return ls;

    }

    @Override
    public List<TimeSlot> getAvailableTimeslot(int chargingSlotId) {
        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(chargingSlotId);
        if(isSlot.isEmpty()){
            System.out.println("slot is not present");
            throw new ResourceNotFound("Slot","not Present");
        }
        List<Booking> allByChargingSlot = bookingRepo.findAllByChargingSlot(isSlot.get());
        List<TimeSlot> alltimeslot = timeslotRepo.findAll();
        alltimeslot.removeIf(allByChargingSlot::contains);
        return alltimeslot;
    }
}
