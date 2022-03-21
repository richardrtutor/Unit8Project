package com.example.Unit8Project.renter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {
    @Query("SELECT r FROM Renter r where r.renter_email = ?1")
    Optional<Renter> findRenterByEmail(String renter_email);

    @Query("SELECT r FROM Renter r where r.renter_name = ?1")
    Optional<Renter> findByName(String renter_name);


}
