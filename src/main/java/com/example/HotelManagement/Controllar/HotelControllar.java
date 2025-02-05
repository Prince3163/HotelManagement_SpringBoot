package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Services.HotelServices;
import com.example.HotelManagement.Services.RoomServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelControllar {

    @Autowired
    private HotelServices hotelServices;

    @Autowired
    private RoomServices roomServices;

    @GetMapping("")
    public List<Hotel> displayAllHotels()
    {
        return hotelServices.displayAllHotels();
    }

    @GetMapping("/get/{id}")
    public Hotel displayHotelDetails(@PathVariable("id") long hotelId)
    {
        return hotelServices.displayHotelDetailsById(hotelId);
    }


    @PostMapping("")
    public ResponseEntity<String> addHotel(@Valid @RequestBody Hotel hotel)
    {
        hotelServices.addHotel(hotel);
        return ResponseEntity.ok("Hotel Added.");
    }


    @PutMapping("")
    public ResponseEntity<String> updateHotel(@Valid @RequestBody Hotel hotel)
    {
        hotelServices.updateHotel(hotel);
        return ResponseEntity.ok("Hotel updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") long hotelId)
    {
        hotelServices.deleteHotelById(hotelId);
        return ResponseEntity.ok("Hotel deleted.");
    }
}