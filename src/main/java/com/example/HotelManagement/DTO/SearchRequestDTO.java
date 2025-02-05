package com.example.HotelManagement.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SearchRequestDTO {
    @NotBlank(message = "Location can't be null.")
    private String location;

    @FutureOrPresent
    @NotNull(message = "Check in date can't be null.")
    private LocalDate checkInDate;

    @Future
    @NotNull(message = "Check out date can't be null.")
    private LocalDate checkOutDate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
