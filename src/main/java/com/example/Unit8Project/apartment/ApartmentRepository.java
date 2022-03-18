package com.example.Unit8Project.apartment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    @Query("SELECT a FROM Apartment a WHERE a.apartment_address = ?1")
    Optional<Apartment> findApartmentByAddress(String apartment_address);
}
