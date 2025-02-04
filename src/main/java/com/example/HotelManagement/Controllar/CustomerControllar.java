package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Repository.CustomerRepository;
import com.example.HotelManagement.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerControllar {

    @Autowired
    private CustomerServices custServices;

    @GetMapping("/{custId}")
    public Customer getCustomerDetails(@PathVariable long custId){
        return custServices.displayCustomerDetailsById(custId);
    }

    @PostMapping("")
    public String addCustomer(@RequestBody Customer customer){
        custServices.addCustomer(customer);
        return "Customer added.";
    }

    @PutMapping("")
    public String updateCustomer(@RequestBody Customer customer){
        custServices.updateCustomer(customer);
        return "Customer Updated.";
    }

    @DeleteMapping("/{custId}")
    public String deleteCustomer(@PathVariable long custId){
        custServices.deleteCustomer(custId);
        return "Customer deletd.";
    }

}
