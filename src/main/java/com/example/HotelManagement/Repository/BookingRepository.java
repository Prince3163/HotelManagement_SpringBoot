package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entities.Bookings;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {
}
