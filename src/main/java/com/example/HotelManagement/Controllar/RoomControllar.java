package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Services.RoomServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//Try to Fetch Hotel ID , One common for class.

@RestController
@RequestMapping("api/hotels/{hotelId}")
public class RoomControllar {

    @Autowired
    private RoomServices roomServices;

    @GetMapping("/rooms/{roomId}")
    public Room getRoomDetails(@PathVariable("roomId") long roomId ){
        return roomServices.displayRoomDetailsById(roomId);
    }

    @GetMapping("/rooms/{roomId}/status")
    public String  checkRoomStatus(@PathVariable("roomId") long roomId ){
        return "Room Id: " +roomId+ " is Currently " +roomServices.checkStatusOfRoomById(roomId);
    }

    @PostMapping("/rooms")
    public void addRoom(@PathVariable long hotelId,@Valid @RequestBody Room room){
        roomServices.addRoom(hotelId ,room);
    }

    @PutMapping("/rooms")
    public void updateRoom(@PathVariable long hotelId,@Valid @RequestBody Room room){
        roomServices.updateRoom(hotelId , room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoom(@PathVariable("roomId") long roomId ){
        roomServices.deleteRoomById(roomId);
    }


}
