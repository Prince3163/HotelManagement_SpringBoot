package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;

import java.util.List;

public interface RoomServices {

    public void addRoom(long hotelId, Room room);
    public Room displayRoomDetailsById(long roomId);
    public void updateRoom(long hotelId, Room room);
    public void deleteRoomById(long roomId);

    public String checkStatusOfRoomById(long roomId);

//    public List<Room> displayRoomsByHotelId(long hotelId);
//    public List<Room> displayAvailableRoomsByHotelId(long hotelId);

}
