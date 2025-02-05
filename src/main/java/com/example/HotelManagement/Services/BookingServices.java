package com.example.HotelManagement.Services;


import com.example.HotelManagement.DTO.BookingRequestDTO;
import com.example.HotelManagement.DTO.SearchRequestDTO;
import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;

import java.time.LocalDate;
import java.util.List;

public interface BookingServices {
    public List<Hotel> getAllHotels();
    public List<Room> getAvailableRoomsByLocation(SearchRequestDTO searchRequestDTO);
    public boolean addBooking(BookingRequestDTO bookingRequestDTO);
    public void deleteBooking(long bookingId);

    public void dateValidation(LocalDate checkInDate, LocalDate checkOutDate);
}
