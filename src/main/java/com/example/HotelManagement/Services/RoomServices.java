package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;

import java.util.List;

public interface RoomServices {

    public List<Bookings> getAllBookingsOfRoom(long roomId);
    public Room getRoomById(long roomId);
    public String getRoomStatus(long roomId);
    public void addRoom(long hotelId, Room room);
    public void updateRoom(long hotelId, Room room);
    public void deleteRoomById(long roomId);

}
