package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entities.Bookings;
import com.example.HotelManagement.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
    List<Bookings> findAllByCustomer_CustomerId(long customerId);
    List<Bookings> findAllByRoom_RoomId(long roomId);
}
