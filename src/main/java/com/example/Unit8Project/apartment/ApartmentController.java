package com.example.Unit8Project.apartment;

import com.example.Unit8Project.landlord.Landlord;
import com.example.Unit8Project.landlord.LandlordRepository;
import com.example.Unit8Project.renter.Renter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<Apartment> getApartments() {
        return apartmentService.getApartments();
    }

    @PostMapping
    public void registerNewApartment(@RequestBody Apartment apartment) {
        apartmentService.addNewApartment(apartment);
    }

    @DeleteMapping(path = "{apartmentAddress}")
    public void deleteApartment(@PathVariable("apartmentAddress") Apartment apartment) {
        apartmentService.deleteApartment(apartment);
    }

    @PutMapping(path = "{apartmentAddress}")
    public void updateApartment
            (@PathVariable("apartmentAddress") String apartmentAddress,
             @RequestParam(required = false) String apartment_address,
             @RequestParam(required = false) String name) {
        apartmentService.updateApartment(apartmentAddress, apartment_address, name);
    }
}
