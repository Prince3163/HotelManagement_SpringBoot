package com.example.HotelManagement.Services;


import com.example.HotelManagement.Entities.Hotel;

import java.util.List;

public interface HotelServices {

    public List<Hotel> getAllHotels();
    public Hotel getHotelById(long hotelId);
    public void addHotel(Hotel hotel);
    public void deleteHotelById(long hotelId);
    public void updateHotel(Hotel hotel);

}