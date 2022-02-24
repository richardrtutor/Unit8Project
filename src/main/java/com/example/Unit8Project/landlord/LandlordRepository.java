package com.example.Unit8Project.landlord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Long> {
    @Query("SELECT l FROM Landlord l WHERE l.email = ?1")
    Optional<Landlord> findLandlordByEmail(String email);
}
