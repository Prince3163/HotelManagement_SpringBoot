package com.example.HotelManagement.Services;

import com.example.HotelManagement.DTO.BookingRequestDTO;
import com.example.HotelManagement.DTO.SearchRequestDTO;
import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Enum.StatusOfBooking;
import com.example.HotelManagement.Exceptions.ObjectNotExistsException;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.CustomerRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServicesImpl implements BookingServices{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Bookings getBookingById(long bookingId) {
        Bookings booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ObjectNotExistsException("Booking not found"));

        return booking;
    }

    @Override
    public List<Room> getAvailableRoomsByLocation(SearchRequestDTO searchRequestDTO) {

        String location = searchRequestDTO.getLocation();
        LocalDate checkInDate = searchRequestDTO.getCheckInDate();
        LocalDate checkOutDate = searchRequestDTO.getCheckOutDate();

        validateDates(checkInDate,checkOutDate);

        return hotelRepository.getAvailableRoomsAtLocation(location,checkInDate,checkOutDate);
    }

    @Transactional
    @Override
    public void addBooking(BookingRequestDTO bookingRequestDTO) {

        LocalDate checkInDate = bookingRequestDTO.getCheckInDate();
        LocalDate checkOutDate = bookingRequestDTO.getCheckOutDate();

        validateDates(checkInDate,checkOutDate);

        Bookings booking = new Bookings();

        Room room = roomRepository.findById(bookingRequestDTO.getRoomId())
                .orElseThrow(() -> new ObjectNotExistsException("Room not found"));

        Customer customer = customerRepository.findById(bookingRequestDTO.getCustId())
                .orElseThrow(() -> new ObjectNotExistsException("Customer not found"));

        booking.setRoom(room);
        booking.setCustomer(customer);
        booking.setCheckInDate(checkInDate);
        booking.setCheckOutDate(checkOutDate);

        bookingRepository.save(booking);
    }

    @Transactional
    @Override
    public void deleteBooking(long bookingId){
        bookingRepository.findById(bookingId).get()
                .setStatusOfBooking( StatusOfBooking.CANCELLED );

        bookingRepository.deleteById(bookingId);
    }

    @Override
    public void validateDates(LocalDate checkInDate,LocalDate checkOutDate)
    {
        if(checkOutDate.isBefore(checkInDate))
            throw new RuntimeException("CheckOut date must be after CheckIn date.");
    }

}
