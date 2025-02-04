package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import com.example.HotelManagement.Exceptions.ObjectAlredyExistsException;
import com.example.HotelManagement.Exceptions.ObjectNotExistsException;
import com.example.HotelManagement.Repository.HotelRepository;
import com.example.HotelManagement.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServicesImpl implements RoomServices{

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    public HotelRepository hotelRepo;

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

    //Here we need to improve and Go to the Room From list at Hotel.
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

//    @Override
//    public List<Room> displayAvailableRoomsByHotelId(long hotelId) {
//
//        return  hotelRepo.findById(hotelId).get()
//                .getRoomList()
//                .stream()
//                .filter(r1 -> r1.getStatusOfRoom().equals("AVAILABLE"))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> displayRoomsByHotelId(long hotelId) {
//        return  hotelRepo.findById(hotelId).get().getRoomList();

//    }

}
