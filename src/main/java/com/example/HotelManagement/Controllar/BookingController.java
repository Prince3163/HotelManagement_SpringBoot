package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.DTO.BookingRequestDTO;
import com.example.HotelManagement.DTO.SearchRequestDTO;
import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Services.BookingServices;
import com.example.HotelManagement.Services.HotelServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingServices bookingServices;

    @Autowired
    private HotelServices hotelServices;

    @GetMapping("/search")
    public List<Room> getAvailableRoomsAtLocation (@Valid @RequestBody SearchRequestDTO searchRequestDTO){
        return bookingServices.getAvailableRoomsByLocation(searchRequestDTO);
    }

    @GetMapping("/{bookingId}")
    public Bookings getBookingById (@PathVariable long bookingId){
        return bookingServices.getBookingById(bookingId);
    }

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels(){
        return hotelServices.getAllHotels();
    }

    @PostMapping("")
    public ResponseEntity<String> makeBooking (@Valid @RequestBody BookingRequestDTO bookingRequestDTO)
    {
        bookingServices.addBooking(bookingRequestDTO);
        return new ResponseEntity<>("Booking Confirmed.", HttpStatus.OK);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking (@PathVariable long bookingId){
        bookingServices.deleteBooking(bookingId);
        return new ResponseEntity<>("Booking Cancelled.",HttpStatus.OK);
    }

}