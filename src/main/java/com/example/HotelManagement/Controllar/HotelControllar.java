package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Services.HotelServices;
import com.example.HotelManagement.Services.HotelServicesImpl;
import com.example.HotelManagement.Services.RoomServices;
import com.example.HotelManagement.Services.RoomServicesImpl;
import jakarta.validation.Valid;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HotelControllar {

    @Autowired
    private HotelServices hotelServices;

    @Autowired
    private RoomServices roomServices;

    @GetMapping("/hotels")
    public List<Hotel> displayAllHotels()
    {
        return hotelServices.displayAllHotels();
    }

    @GetMapping("/hotels/{id}")
    public Hotel displayHotelDetails(@PathVariable("id") long hotelId)
    {
        return hotelServices.displayHotelDetailsById(hotelId);
    }


    @PostMapping("/hotels")
    public ResponseEntity<String> addHotel(@Valid @RequestBody Hotel hotel)
    {
        hotelServices.addHotel(hotel);
        return ResponseEntity.ok("Hotel Added.");
    }


    @PutMapping("/hotels")
    public ResponseEntity<String> updateHotel(@Valid @RequestBody Hotel hotel)
    {
        hotelServices.updateHotel(hotel);
        return ResponseEntity.ok("Hotel updated.");
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") long hotelId)
    {
        hotelServices.deleteHotelById(hotelId);
        return ResponseEntity.ok("Hotel deleted.");
    }

}