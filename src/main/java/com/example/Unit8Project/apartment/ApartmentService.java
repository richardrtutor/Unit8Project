package com.example.Unit8Project.apartment;

import com.example.Unit8Project.renter.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> getApartments() {
        return apartmentRepository.findAll();
    }

    public void addNewApartment(Apartment apartment) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findApartmentByAddress(apartment.getAddress());

        if(apartmentOptional.isPresent()) {
            throw new IllegalStateException("This apartment_address is already related to an apartment");
        } else {
            apartmentRepository.save(apartment);
        }
    }

    public void deleteApartment(Apartment apartment) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findApartmentByAddress(apartment.getAddress());

        if(apartmentOptional.isPresent()) {
            apartmentRepository.delete(apartment);
        } else {
            throw new IllegalStateException("Taco Tuesday is on Wednesday today");
        }
    }

    @Transactional
    public void updateApartment(String apartmentAddress, String apartment_address, String name) {
        Apartment apartment = apartmentRepository.findApartmentByAddress(apartmentAddress).orElseThrow(() -> new IllegalStateException("This apartment does not seem to exist!"));

        if (apartment_address != null && apartment_address.length() > 0) {
            apartment.setAddress(apartment_address);
        }

        if (name != null && name.length() > 0) {
            Renter renter = apartmentRepository.findByName(name).orElseThrow(() -> new IllegalStateException("A renter by this name does not exist!"));
            apartment.setRenter(renter);
            apartment.setName(name);
        }
      }
    }