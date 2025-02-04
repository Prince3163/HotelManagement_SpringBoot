package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Exceptions.ObjectAlredyExistsException;
import com.example.HotelManagement.Exceptions.ObjectNotExistsException;
import com.example.HotelManagement.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServicesImpl implements HotelServices{

    @Autowired
    private HotelRepository hotelRepo;

//    @Override
//    public List<Room> displayAvailableRoomsByHotelId(int id) {
//
//        return  hotelRepo.findById(id).get()
//                    .getRoomList()
//                    .stream()
//                    .filter(r1 -> r1.getStatusOfRoom().equals("AVAILABLE"))
//                    .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Room> displayRoomsByHotelId(int id) {
//        return  hotelRepo.findById(id).get().getRoomList();
//    }

    @Override
    public void addHotel(Hotel hotel) {
        if(hotelRepo.existsById( hotel.getId() )) {
            throw new ObjectAlredyExistsException("You can't add, Hotel alredy exists.");
        }

        if (hotelRepo.existsByEmail(hotel.getEmail()) ){
            throw new ObjectAlredyExistsException("You can't add, Hotel exists with same EMAIL.");
        }

        hotelRepo.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        if(! hotelRepo.existsById( hotel.getId() )) {
            throw new ObjectNotExistsException("You can't update, Hotel not exists!!");
        }
        if (hotelRepo.existsByEmail(hotel.getEmail()) ){
            throw new ObjectAlredyExistsException("You can't update, Hotel exists with same EMAIL.");
        }
        hotelRepo.save(hotel);
    }

    @Override
    public void deleteHotelById(long hotelId) {

        if(! hotelRepo.existsById( hotelId )) {
            throw new ObjectNotExistsException("You can't delete, Hotel not exists!!");
        }

        hotelRepo.deleteById(hotelId);
    }

    @Override
    public List<Hotel> displayAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel displayHotelDetailsById(long hotelId) {
        if(! hotelRepo.existsById( hotelId )) {
            throw new ObjectNotExistsException("Nothing to display, Hotel not exists!!");
        }
        return hotelRepo.findById(hotelId).get();
    }
}
