package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.DTO.BookingRequestDTO;
import com.example.HotelManagement.DTO.SearchRequestDTO;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Services.BookingServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class BookingControllar {

    @Autowired
    private BookingServices bookingServices;

    @GetMapping("/hotel-search")
    public List<Room> getAvailableRoomsAtLocation (@Valid @RequestBody SearchRequestDTO searchRequestDTO){
        return bookingServices.getAvailableRoomsByLocation(searchRequestDTO);
    }

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels(){
        return bookingServices.getAllHotels();
    }

    @PostMapping("/hotel-booking")
    public ResponseEntity<String> addBooking (@Valid @RequestBody BookingRequestDTO bookingRequestDTO)
    {
        if (bookingServices.addBooking(bookingRequestDTO)){
            return ResponseEntity.ok("Booking Confirmed");
        }
        return ResponseEntity.badRequest().body("Something went wrong");
    }

    @DeleteMapping("/booking-cancel/{bookingId}")
    public ResponseEntity<String> deleteBooking (@PathVariable long bookingId){
        bookingServices.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking Cancelled.");
    }

}