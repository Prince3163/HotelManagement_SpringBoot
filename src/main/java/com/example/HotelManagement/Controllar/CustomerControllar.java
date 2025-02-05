package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Services.CustomerServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerControllar {

    @Autowired
    private CustomerServices custServices;

    @GetMapping("/{custId}")
    public Customer getCustomerDetails(@PathVariable long custId){
        return custServices.displayCustomerDetailsById(custId);
    }

    @GetMapping("/{custId}/bookings")
    public List<Bookings> getAllBookingsOfCustomer(@PathVariable long custId)
    {
        return custServices.getAllBookingsOfCustomer(custId);
    }

    @PostMapping("")
    public String addCustomer(@Valid @RequestBody Customer customer){
        custServices.addCustomer(customer);
        return "Customer added.";
    }

    @PutMapping("")
    public String updateCustomer( @Valid @RequestBody Customer customer){
        custServices.updateCustomer(customer);
        return "Customer Updated.";
    }

    @DeleteMapping("/{custId}")
    public String deleteCustomer(@PathVariable long custId){
        custServices.deleteCustomer(custId);
        return "Customer deletd.";
    }

}
