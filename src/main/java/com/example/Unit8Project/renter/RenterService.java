package com.example.Unit8Project.renter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RenterService {
    private final RenterRepository renterRepository;

    @Autowired
        public RenterService(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    public List<Renter> getRenters() {
        return renterRepository.findAll();
    }

    public void addNewRenter(Renter renter) {
        Optional<Renter> renterOptional = renterRepository.findRenterByEmail(renter.getEmail());
        if (renterOptional.isPresent()) {
            throw new IllegalStateException("This renter_email is already linked to an account!");
        } else {
            renterRepository.save(renter);
        }
    }

    public void deleteRenter(Long renterId) {
        boolean exists = renterRepository.existsById(renterId);

        if(!exists) {
            throw new IllegalStateException("Renter with ID: " + renterId + "does not exist!");
        }

        renterRepository.deleteById(renterId);
    }

    @Transactional
    public void updateRenter(Long renterId, String renter_name, String renter_email) {
        Renter renter = renterRepository.findById(renterId)
                .orElseThrow(() -> new IllegalStateException(
                        "Renter with ID: '" + renterId + "' does not exist"
                ));

        if (renter_name != null && renter_name.length() > 0 && !Objects.equals(renter.getName(),
                renter_name)) {
            renter.setName(renter_name);
        }

        if (renter_name != null && renter_name.length() > 0 && !Objects.equals(renter.getEmail(), renter_email)) {
            Optional<Renter> renterOptional = renterRepository.findRenterByEmail(renter_email);
            if (renterOptional.isPresent()) {
                throw new IllegalStateException("Email is already in use");
            }
            renter.setEmail(renter_email);
        }
    }
}

