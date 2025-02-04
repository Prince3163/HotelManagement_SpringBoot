package com.example.HotelManagement.Services;

import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Exceptions.ObjectAlredyExistsException;
import com.example.HotelManagement.Exceptions.ObjectNotExistsException;
import com.example.HotelManagement.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesImpl implements CustomerServices{

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public void addCustomer(Customer customer) {
        if(customerRepo.existsByEmail(customer.getEmail()) ){
            throw new ObjectAlredyExistsException("Customer alredy exist with this email.");
        }
        customerRepo.save(customer);
    }

    @Override
    public Customer displayCustomerDetailsById(long custId) {
        if(! customerRepo.existsById(custId)){
            throw new ObjectNotExistsException("Customer not exist.");
        }
        return customerRepo.findById(custId).get();
    }

    @Override
    public void updateCustomer(Customer customer) {
        if( ! customerRepo.existsById( customer.getCustId() )){
            throw new ObjectNotExistsException("Customer not exist.");
        }
        if(customerRepo.existsByEmail(customer.getEmail()) ){
            throw new ObjectAlredyExistsException("Customer alredy exist with this email.");
        }

        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(long custId) {
        if(! customerRepo.existsById(custId)){
            throw new ObjectNotExistsException("Customer not exist.");
        }
        customerRepo.deleteById(custId);
    }
}
