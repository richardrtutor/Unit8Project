package com.example.Unit8Project.renter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RenterConfig {

    @Bean
    CommandLineRunner commandLineRunner2(RenterRepository repository) {
        return args -> {
            Renter Miles = new Renter("Miles", "662-266-1769", "Miles@dragonmail.com");
            repository.save(Miles);
        };
    }
}
