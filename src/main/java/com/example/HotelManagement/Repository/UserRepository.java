package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByUsername(String username);

    Users findByUsername(String username);
}
