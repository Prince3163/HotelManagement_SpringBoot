package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.CustomerRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServicesImpl implements BookingServices{

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public List<Hotel> getHotelsByLocation(String location) {
        return hotelRepo.findAllByLocation(location);
    }

    @Override
    public void addBooking(long custId, long roomId, LocalDate checkInDate, LocalDate checkOutDate) {

    }

    @Override
    public void addBooking(long custId, long roomId) {
        LocalDate checkInDate = LocalDate.of(2025,2,5);
        LocalDate checkOutDate = LocalDate.of(2025,2,9);
        Customer customer = customerRepo.findById(custId).get();
        Room room = roomRepo.findById(roomId).get();

        Bookings bookings = new Bookings();

        bookings.setCheckInDate(checkInDate);
        bookings.setCheckOutDate(checkOutDate);
        bookings.setCustomer(customer);
        bookings.setRoom(room);

        bookingRepo.save(bookings);
    }
}
