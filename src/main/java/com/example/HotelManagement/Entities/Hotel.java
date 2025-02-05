package com.example.HotelManagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NotNull
    private long hotelId;

    @NotBlank(message = "Name can't be blank.")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Location can't be blank.")
    @Column(nullable = false)
    private String location;

    @Email(message = "Please, Enter a valid email.")
    @Column(unique = true , nullable = false)
    private String email;

    @OneToMany(mappedBy = "hotel" , cascade = CascadeType.ALL)
    private List<Room> roomsList = new ArrayList<>();

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @JsonIgnore
    public long getId() {
        return hotelId;
    }

    public List<Room> getRoomsList() {
        return roomsList;
    }

    public void setRoomsList(List<Room> roomsList) {
        this.roomsList = roomsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}