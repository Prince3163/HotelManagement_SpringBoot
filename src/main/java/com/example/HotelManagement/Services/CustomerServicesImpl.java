package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Exceptions.ObjectAlredyExistsException;
import com.example.HotelManagement.Exceptions.ObjectNotExistsException;
import com.example.HotelManagement.Repository.BookingRepository;
import com.example.HotelManagement.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void addCustomer(Customer customer) {
        if(customerRepository.existsByEmail(customer.getEmail()) ){
            throw new ObjectAlredyExistsException("Customer alredy exist with this email.");
        }
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(() -> new ObjectNotExistsException("Customer not found"));

        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        if( ! customerRepository.existsById( customer.getCustomerId() )){
            throw new ObjectNotExistsException("Customer not exist.");
        }
        if(customerRepository.existsByEmail( customer.getCustomerId() , customer.getEmail()) ){
            throw new ObjectAlredyExistsException("Customer alredy exist with this email.");
        }

        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long customerId) {
        if(! customerRepository.existsById(customerId)){
            throw new ObjectNotExistsException("Customer not exist.");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Bookings> getAllBookingsOfCustomer(long customerId) {
        return bookingRepository.findAllByCustomer_CustomerId(customerId);
    }
}
