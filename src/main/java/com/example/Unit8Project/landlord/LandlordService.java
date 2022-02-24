package com.example.Unit8Project.landlord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LandlordService {
    private final LandlordRepository landlordRepository;

    @Autowired
    public LandlordService(LandlordRepository landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    public List<Landlord > getLandlords() {
        return landlordRepository.findAll();
    }

    public void addNewLandlord(Landlord landlord) {
        Optional<Landlord> landlordOptional = landlordRepository.findLandlordByEmail(landlord.getEmail());
        if (landlordOptional.isPresent()) {
            throw new IllegalStateException("This email is already linked to an account!");
        } else {
            landlordRepository.save(landlord);
        }
    }

    public void deleteLandlord(Long landlordId) {
        boolean exists = landlordRepository.existsById(landlordId);

        if(!exists) {
            throw new IllegalStateException("Landlord with ID: " + landlordId + "does not exist!");
        }

        landlordRepository.deleteById(landlordId);
    }

    @Transactional
    public void updateLandlord(Long landlordId, String name, String email) {
        Landlord landlord = landlordRepository.findById(landlordId)
                .orElseThrow(() -> new IllegalStateException(
                        "Landlord with ID: '" + landlordId + "' does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(landlord.getName(),
                name)) {
                    landlord.setName(name);
        }

        if (name != null && name.length() > 0 && !Objects.equals(landlord.getEmail(), email)) {
            Optional<Landlord> landlordOptional = landlordRepository.findLandlordByEmail(email);
            if (landlordOptional.isPresent()) {
                throw new IllegalStateException("Email is already in use");
            }
            landlord.setEmail(email);
        }
    }
}
