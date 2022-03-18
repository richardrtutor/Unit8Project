package com.example.Unit8Project.renter;

import com.example.Unit8Project.landlord.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/renters")
public class RenterController {
    private final RenterService renterService;

    @Autowired
    public RenterController(RenterService renterService) {this.renterService = renterService;}

    @GetMapping
    public List<Renter> getRenters() {
        return renterService.getRenters();
    }

    @PostMapping
    public void registerNewRenter(@RequestBody Renter renter) {
        renterService.addNewRenter(renter);
    }

}
