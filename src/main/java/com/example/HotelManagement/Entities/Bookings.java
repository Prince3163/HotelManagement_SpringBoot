package com.example.HotelManagement.Entities;

import com.example.HotelManagement.Enum.StatusOfBooking;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "room_id" , nullable = false)
    private Room room;

    @FutureOrPresent(message = "You can't book for past date.")
    private LocalDate checkInDate;

    @FutureOrPresent(message = "You can't book for past date.")
    private LocalDate checkOutDate;

    @Enumerated(EnumType.STRING)
    private StatusOfBooking statusOfBooking = StatusOfBooking.CONFIRMED;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public StatusOfBooking getStatusOfBooking() {
        return statusOfBooking;
    }

    public void setStatusOfBooking(StatusOfBooking statusOfBooking) {
        this.statusOfBooking = statusOfBooking;
    }
}
