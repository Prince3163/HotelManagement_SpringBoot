package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Customer;

public interface CustomerServices {

    public void addCustomer(Customer customer);
    public Customer displayCustomerDetailsById(long custId);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(long custId);

}