package com.example.HotelManagement.DTO;

import com.example.HotelManagement.Enum.StatusOfBooking;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingRequestDTO {

    @NotNull(message = "Room id can't be null.")
    private long roomId;

    @NotNull(message = "Customer id can't be null.")
    private long custId;

    @FutureOrPresent
    @NotNull(message = "Check in date can't be null.")
    private LocalDate checkInDate;

    @Future
    @NotNull(message = "Check out date can't be null.")
    private LocalDate checkOutDate;

    @Enumerated
    private StatusOfBooking statusOfBooking = StatusOfBooking.CONFIRMED;



    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
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
