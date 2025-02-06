package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT EXISTS (SELECT c FROM Customer c WHERE c.email = :email AND c.customerId !=customerId)")
    boolean existsByEmail(long customerId,String email);
}
