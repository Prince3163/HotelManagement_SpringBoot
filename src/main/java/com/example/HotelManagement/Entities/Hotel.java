package com.example.HotelManagement.Entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

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

    public long getId() {
        return hotelId;
    }

    public void setId(long hotelId) {
        this.hotelId = hotelId;
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

    public List<Room> getRoomList() {
        return roomsList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomsList = roomList;
    }
}
