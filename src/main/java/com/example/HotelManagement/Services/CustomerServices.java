package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;

import java.util.List;

public interface CustomerServices {

    public List<Bookings> getAllBookingsOfCustomer(long customerId);
    public Customer getCustomerById(long customerId);
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(long customerId);
}