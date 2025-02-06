package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Exceptions.ObjectAlredyExistsException;
import com.example.HotelManagement.Exceptions.ObjectNotExistsException;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServicesImpl implements RoomServices{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    public HotelRepository hotelRepository;

    @Autowired
    public BookingRepository bookingRepository;

    @Override
    public void addRoom(long hotelId, Room room) {

        if(roomRepository.existsByRoomNoAndHotelId(room.getRoomNo(),  hotelId))
        {
            throw new ObjectAlredyExistsException("Room_no alredy exists in this hotel.");
        }
        Hotel hotel = hotelRepository.findById( hotelId ).get();
        room.setHotel(hotel);
        roomRepository.save(room);
    }

    @Override
    public void updateRoom(long hotelId, Room room) {

        if(roomRepository.existsByRoomNoAndHotelId(room.getRoomNo(),  hotelId))
        {
            throw new ObjectAlredyExistsException("Room_no alredy exists in this hotel.");
        }

        Hotel hotel = hotelRepository.findById(hotelId).get();
        room.setHotel(hotel);
        roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(long roomId) {
        if(! roomRepository.existsById(roomId))
        {
            throw new ObjectNotExistsException("Room not exist.");
        }
        roomRepository.deleteById(roomId);
    }

    @Override
    public Room getRoomById(long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new ObjectNotExistsException("Rom not Found."));
    }

    @Override
    public String getRoomStatus(long roomId) {
        if(! roomRepository.existsById(roomId))
        {
            throw new ObjectNotExistsException("Room not exist.");
        }
        return roomRepository.findById(roomId).get().getStatusOfRoom().toString();
    }

    @Override
    public List<Bookings> getAllBookingsOfRoom(long roomId) {
        return bookingRepository.findAllByRoom_RoomId(roomId);
    }
}
