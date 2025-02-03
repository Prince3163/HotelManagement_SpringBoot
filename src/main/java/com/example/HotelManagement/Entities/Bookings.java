package com.example.HotelManagement.Entities;

import com.example.HotelManagement.Enum.StatusOfBooking;
import jakarta.persistence.*;

import java.sql.Date;
import java.text.DateFormat;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private Customer customer;

    @OneToMany
    private Room room;

    private Date checkInDate;

    private Date checkOutDate;

    @Enumerated(EnumType.STRING)
    private StatusOfBooking statusOfBooking;
}
