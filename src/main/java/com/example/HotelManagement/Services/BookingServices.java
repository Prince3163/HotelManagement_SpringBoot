package com.example.HotelManagement.Services;


import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingServices {
    public List<Hotel> getAllHotels();
    public List<Hotel> getHotelsByLocation(String location);
    public void addBooking(long custId, long roomId , LocalDate checkInDate, LocalDate checkOutDate);
    public void addBooking(long custId, long roomId);

}
