package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;

import java.util.List;

public interface CustomerServices {

    public void addCustomer(Customer customer);
    public Customer displayCustomerDetailsById(long custId);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(long custId);
    public List<Bookings> getAllBookingsOfCustomer(long custId);
}