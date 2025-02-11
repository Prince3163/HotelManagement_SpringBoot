package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Services.HotelServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels/")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    @GetMapping
    public List<Hotel> displayAllHotels()
    {
        return hotelServices.getAllHotels();
    }

    @GetMapping("{hotelId}")
    public Hotel displayHotelDetails(@PathVariable("hotelId") long hotelId)
    {
        return hotelServices.getHotelById(hotelId);
    }

    @PostMapping
    public ResponseEntity<String> addHotel(@Valid @RequestBody Hotel hotel)
    {
        hotelServices.addHotel(hotel);
        return new ResponseEntity<>("Hotel Added.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateHotel(@Valid @RequestBody Hotel hotel)
    {
        hotelServices.updateHotel(hotel);
        return new ResponseEntity<>("Hotel Updated.", HttpStatus.OK);
    }

    @DeleteMapping("{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable("hotelId") long hotelId)
    {
        hotelServices.deleteHotelById(hotelId);
        return new ResponseEntity<>("Hotel Deleted.", HttpStatus.OK);
    }
}
