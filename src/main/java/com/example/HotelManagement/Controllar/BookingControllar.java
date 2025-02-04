package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/{customerId}")
public class BookingControllar {

    @Autowired
    private BookingServices bookingServices;

    @GetMapping("/Hotel-Search/{location}")
    public List<Hotel> getHotelsByLocation(@PathVariable("location") String location){
        return bookingServices.getHotelsByLocation(location);
    }

    @GetMapping("/Hotel-Search/all")
    public List<Hotel> getAllHotels(){
        return bookingServices.getAllHotels();
    }

    @PostMapping("/Hotel-Booking/{roomId}")
    public ResponseEntity<String> addBooking (@PathVariable("customerId") long custId , @PathVariable("roomId") long roomId )
    {
        bookingServices.addBooking(custId , roomId );
        return ResponseEntity.ok("Booking Confirmed");
    }

}