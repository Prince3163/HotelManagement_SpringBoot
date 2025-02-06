package com.example.HotelManagement.Controllar;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Customer;
import com.example.HotelManagement.Services.CustomerServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/{customerId}")
    public Customer getCustomerDetails(@PathVariable long customerId){
        return customerServices.getCustomerById(customerId);
    }

    @GetMapping("/{customerId}/bookings")
    public List<Bookings> getAllBookingsOfCustomer(@PathVariable long customerId)
    {
        return customerServices.getAllBookingsOfCustomer(customerId);
    }

    @PostMapping("")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer){
        customerServices.addCustomer(customer);
        return new ResponseEntity<>("Customer Added.", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<String> updateCustomer( @Valid @RequestBody Customer customer){
        customerServices.updateCustomer(customer);
        return new ResponseEntity<>("Hotel Updated.", HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long customerId){
        customerServices.deleteCustomer(customerId);
        return new ResponseEntity<>("Hotel Deleted.", HttpStatus.OK);
    }

}
