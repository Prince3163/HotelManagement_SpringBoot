package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entities.Hotel;
import com.example.HotelManagement.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    boolean existsByEmail(String email);

    @Query("SELECT EXISTS (SELECT h FROM Hotel h WHERE h.email = :email AND h.hotelId !=hotelId)")
    boolean existsByEmail(long hotelId,String email);

    @Query("SELECT r FROM Hotel h JOIN h.roomsList r " +
            "WHERE h.location = :location " +
            "AND r.id NOT IN (SELECT b.room.id FROM Bookings b " +
            "WHERE :checkInDate BETWEEN b.checkInDate AND b.checkOutDate " +
            "OR :checkOutDate BETWEEN b.checkInDate AND checkOutDate)")
    List<Room> getAvailableRoomsAtLocation(@Param("location") String location,
                                            @Param("checkInDate") LocalDate checkInDate,
                                            @Param("checkOutDate") LocalDate checkOutDate);

}