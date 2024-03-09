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

        BookingDTO bookingdto=new BookingDTO();



        bookingdto.setUser(modelMapper.map(save.getUser(), UserDTO.class));
        bookingdto.setChargingSlot(modelMapper.map(save.getChargingSlot(), ChargingSlotDTO.class));
        bookingdto.setDate(save.getDate());
        bookingdto.setTimeSlot(modelMapper.map(save.getTimeSlot(), TimeSlotDTO.class));
        bookingdto.setStatus(save.getStatus());

        return bookingdto;
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

        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(ChargingSlotId);
        if (isSlot.isEmpty()){
            System.out.println("not found slot");
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
            System.out.println("user not found");
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
            System.out.println("user not found");
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
//        Optional<Booking> isBooking = bookingRepo.findById(bookingId);
//        if(isBooking.isEmpty()) {
//            System.out.println("booking is not availble");
//            return null;
//        }
//        Booking booking = isBooking.get();
//
//        String bookingdate= booking.getDate().toString();
//        String todaydate=new Date().toString();




        return "it will be developed";




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
            if(alltimeslot.contains(b.getTimeSlot())){
                ls.add(modelMapper.map(b.getTimeSlot(),TimeSlotDTO.class));
            }
        }
        return ls;

    }

    @Override
    public List<TimeSlot> getAvailableTimeslot(int chargingSlotId) {
        Optional<ChargingSlot> isSlot = chargingSlotRepo.findById(chargingSlotId);
        if(isSlot.isEmpty()){
            System.out.println("slot is not present");
            return  null;
        }
        List<Booking> allByChargingSlot = bookingRepo.findAllByChargingSlot(isSlot.get());
        List<TimeSlot> alltimeslot = timeslotRepo.findAll();

        for (Booking b:allByChargingSlot){
            if(alltimeslot.contains(b.getTimeSlot())){

                alltimeslot.remove(b.getTimeSlot());
            }
        }
        return alltimeslot;

    }
}
