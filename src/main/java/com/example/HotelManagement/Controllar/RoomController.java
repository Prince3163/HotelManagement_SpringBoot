package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Services.RoomServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels/{hotelId}/rooms/")
public class RoomController {

    @Autowired
    private RoomServices roomServices;

    @GetMapping("{roomId}/")
    public Room getRoomDetails(@PathVariable("roomId") long roomId ){
        return roomServices.getRoomById(roomId);
    }

    @GetMapping("{roomId}/status")
    public String checkRoomStatus(@PathVariable("roomId") long roomId ){
        return "Room Id: " +roomId+ " is Currently " +roomServices.getRoomStatus(roomId);
    }

    @GetMapping("bookings/{roomId}")
    public List<Bookings> getAllBookingsOfRoom(@PathVariable long roomId)
    {
        return roomServices.getAllBookingsOfRoom(roomId);
    }

    @PostMapping
    public ResponseEntity<String> addRoom(@PathVariable long hotelId, @Valid @RequestBody Room room){
        roomServices.addRoom(hotelId ,room);
        return new ResponseEntity<>("Room added.", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateRoom(@PathVariable long hotelId,@Valid @RequestBody Room room){
        roomServices.updateRoom(hotelId , room);
        return new ResponseEntity<>("Room Updated.", HttpStatus.OK);
    }

    @DeleteMapping("{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable("roomId") long roomId ){
        roomServices.deleteRoomById(roomId);
        return new ResponseEntity<>("Room Deleted.", HttpStatus.OK);
    }
}
