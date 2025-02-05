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
    private RoomRepository roomRepo;

    @Autowired
    public HotelRepository hotelRepo;

    @Autowired
    public BookingRepository bookingRepo;

    @Override
    public void addRoom(long hotelId, Room room) {

        if(roomRepo.existsByRoomNoAndHotelId(room.getRoomNo(),  hotelId))
        {
            throw new ObjectAlredyExistsException("Room_no alredy exists in this hotel.");
        }
        Hotel hotel = hotelRepo.findById( hotelId ).get();
        room.setHotel(hotel);
        roomRepo.save(room);
    }

    @Override
    public void updateRoom(long hotelId, Room room) {

        if(roomRepo.existsByRoomNoAndHotelId(room.getRoomNo(),  hotelId))
        {
            throw new ObjectAlredyExistsException("Room_no alredy exists in this hotel.");
        }

        Hotel hotel = hotelRepo.findById(hotelId).get();
        room.setHotel(hotel);
        roomRepo.save(room);
    }

    @Override
    public void deleteRoomById(long roomId) {
        if(! roomRepo.existsById(roomId))
        {
            throw new ObjectNotExistsException("Room not exist.");
        }
        roomRepo.deleteById(roomId);
    }

    @Override
    public Room displayRoomDetailsById(long roomId) {
        if(! roomRepo.existsById(roomId))
        {
            throw new ObjectNotExistsException("Room not exist.");
        }

        return roomRepo.findById(roomId).get();
    }

    @Override
    public String checkStatusOfRoomById(long roomId) {
        if(! roomRepo.existsById(roomId))
        {
            throw new ObjectNotExistsException("Room not exist.");
        }
        return roomRepo.findById(roomId).get().getStatusOfRoom().toString();
    }

    @Override
    public List<Bookings> getAllBookingsOfRoom(long roomId) {
        return bookingRepo.findAllByRoom_RoomId(roomId);
    }
}
