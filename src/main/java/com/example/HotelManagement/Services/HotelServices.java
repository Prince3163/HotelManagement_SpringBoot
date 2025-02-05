package com.example.HotelManagement.Services;


import com.example.HotelManagement.Entities.Hotel;

import java.util.List;

public interface HotelServices {

    public List<Hotel> displayAllHotels();

    public void addHotel(Hotel hotel);
    public Hotel displayHotelDetailsById(long hotelId);
    public void deleteHotelById(long hotelId);
    public void updateHotel(Hotel hotel);

}