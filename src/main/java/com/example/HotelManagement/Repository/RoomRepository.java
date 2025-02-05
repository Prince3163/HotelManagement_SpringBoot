package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long > {
    boolean existsByRoomNoAndHotelId(int roomNo , long hotelId);

}
