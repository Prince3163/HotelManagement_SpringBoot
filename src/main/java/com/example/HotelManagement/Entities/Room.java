package com.example.HotelManagement.Entities;

import com.example.HotelManagement.Enum.StatusOfRoom;
import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int roomNo;

    @ManyToOne
    private Hotel hotel;

    @Enumerated(EnumType.STRING)
    private StatusOfRoom statusOfRoom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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