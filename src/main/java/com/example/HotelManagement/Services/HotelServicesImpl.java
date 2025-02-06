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
    private HotelRepository hotelRepository;

    @Override
    public void addHotel(Hotel hotel) {
        if(hotelRepository.existsById( hotel.getHotelId())) {
            throw new ObjectAlredyExistsException("You can't add, Hotel alredy exists.");
        }

        if (hotelRepository.existsByEmail( hotel.getEmail()) ){
            throw new ObjectAlredyExistsException("You can't add, Hotel exists with same EMAIL.");
        }
        hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        if(! hotelRepository.existsById( hotel.getHotelId() )) {
            throw new ObjectNotExistsException("You can't update, Hotel not exists!!");
        }

        //Modify This to accept same mail as well
        if (hotelRepository.existsByEmail(hotel.getId(), hotel.getEmail() ) ){
            throw new ObjectAlredyExistsException("You can't update, Hotel exists with same EMAIL.");
        }
        hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotelById(long hotelId) {

        if(! hotelRepository.existsById( hotelId )) {
            throw new ObjectNotExistsException("You can't delete, Hotel not exists!!");
        }
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ObjectNotExistsException("Hotel not found"));
    }
}
