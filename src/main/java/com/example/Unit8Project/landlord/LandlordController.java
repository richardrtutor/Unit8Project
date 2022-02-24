package com.example.Unit8Project.landlord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/landlord")
public class LandlordController {
    private final LandlordService landlordService;

    @Autowired
    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @GetMapping
    public List<Landlord> getLandlords() {
        return landlordService.getLandlords();
    }

    @PostMapping
    public void registerNewLandlord(@RequestBody Landlord landlord) {
        landlordService.addNewLandlord(landlord);
    }

    @DeleteMapping(path = "{landlordId}")
    public void deleteLandlord(@PathVariable("landlordId") Long landlordId) {
        landlordService.deleteLandlord(landlordId);
    }

    @PutMapping(path = "{landlordId}")
    public void updateLandlord(@PathVariable("landlordId") Long landlordId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email) {
        landlordService.updateLandlord(landlordId, name, email);
    }
}
