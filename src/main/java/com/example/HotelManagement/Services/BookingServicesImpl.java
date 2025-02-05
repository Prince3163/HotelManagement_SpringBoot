package com.example.HotelManagement.Services;

import com.example.HotelManagement.DTO.BookingRequestDTO;
import com.example.HotelManagement.DTO.SearchRequestDTO;
import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Enum.StatusOfBooking;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.CustomerRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public List<Room> getAvailableRoomsByLocation(SearchRequestDTO searchRequestDTO) {

        String location = searchRequestDTO.getLocation();
        LocalDate checkInDate = searchRequestDTO.getCheckInDate();
        LocalDate checkOutDate = searchRequestDTO.getCheckOutDate();

        //Auto throws if invalid.
        dateValidation(checkInDate,checkOutDate);

        return hotelRepo.findAvailableRoomsAtLocation(location,checkInDate,checkOutDate);
    }

    @Override
    public boolean addBooking(BookingRequestDTO bookingRequestDTO) {
        try {
            LocalDate checkInDate = bookingRequestDTO.getCheckInDate();
            LocalDate checkOutDate = bookingRequestDTO.getCheckOutDate();

            dateValidation(checkInDate,checkOutDate);

            Bookings booking = new Bookings();

            Room room = roomRepo.findById( bookingRequestDTO.getRoomId() ).get();
            Customer customer = customerRepo.findById( bookingRequestDTO.getCustId() ).get();

            booking.setRoom(room);
            booking.setCustomer(customer);
            booking.setCheckInDate(checkInDate);
            booking.setCheckOutDate(checkOutDate);

            bookingRepo.save(booking);

            return true;
        }
        catch (Exception exception){
            return false;
        }
    }

    @Override
    public void deleteBooking(long bookingId){
        bookingRepo.findById(bookingId).get().setStatusOfBooking( StatusOfBooking.CANCELLED );
        bookingRepo.deleteById(bookingId);
    }

    @Override
    public void dateValidation(LocalDate checkInDate,LocalDate checkOutDate)
    {
        if(checkOutDate.isBefore(checkInDate))
            throw new RuntimeException("CheckOut date must be after CheckIn date.");
    }

}
