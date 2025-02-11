package com.example.HotelManagement.Entities;

import com.example.HotelManagement.Enum.StatusOfRoom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

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

    @JsonProperty("HotelName")
    public String getHotelName() {
        return hotel != null ? hotel.getName() : null;
    }

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private StatusOfRoom statusOfRoom = StatusOfRoom.AVAILABLE;

    @JsonIgnore
    @OneToMany(mappedBy = "room" , cascade = CascadeType.ALL)
    private List<Bookings> roomBookingList = new ArrayList<>();

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

    public List<Bookings> getRoomBookingList() {
        return roomBookingList;
    }

    public void setRoomBookingList(List<Bookings> roomBookingList) {
        this.roomBookingList = roomBookingList;
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
