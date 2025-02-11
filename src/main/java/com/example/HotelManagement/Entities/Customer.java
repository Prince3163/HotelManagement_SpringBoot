package com.example.HotelManagement.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long customerId;

    @NotNull(message = "UserId can't be null.")
    private long userId;

    @NotBlank(message = "Name can't be null.")
    private String name;

    @Column( unique = true )
    @Email(message = "Please enter a valid EMAIL.")
    private String email;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    private List<Bookings> customerBookingList = new ArrayList<>();

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId( long custId) {
        this.customerId = custId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bookings> getCustomerBookingList() {
        return customerBookingList;
    }

    public void setCustomerBookingList(List<Bookings> customerBookingList) {
        this.customerBookingList = customerBookingList;
    }
}
