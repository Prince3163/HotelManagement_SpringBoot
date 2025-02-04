package com.example.HotelManagement.Entities;

import com.example.HotelManagement.Enum.StatusOfRoom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames ={"roomNo","hotel_id"})})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long roomId;

    @NotNull(message = "RoomNo. can't be null.")
    private int roomNo;

    @NotNull(message = "Price can't be null.")
    private float price;

    @NotBlank(message = "RoomType can't be blank.")
    private String roomType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    //Use DTO classes Instead.
    @JsonProperty("HotelName")
    public String getHotelName() {
        return hotel != null ? hotel.getName() : null;
    }

    @Enumerated(EnumType.STRING)
    private StatusOfRoom statusOfRoom = StatusOfRoom.AVAILABLE;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public StatusOfRoom getStatusOfRoom() {
        return statusOfRoom;
    }

    public void setStatusOfRoom(StatusOfRoom statusOfRoom) {
        this.statusOfRoom = statusOfRoom;
    }
}