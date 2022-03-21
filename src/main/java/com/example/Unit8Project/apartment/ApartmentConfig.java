package com.example.Unit8Project.apartment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApartmentConfig {

    @Bean
    CommandLineRunner commandLineRunner3(ApartmentRepository repository) {
        return args -> {
            Apartment one = new Apartment(null, null,"Rome", 600, 1200);
            Apartment two = new Apartment(null, null, "Hoover Dam Snackbar", 800, 1800);
            Apartment three = new Apartment(null, null, "5078 someroad county", 650, 800);
            repository.saveAll(
                    List.of(one, two, three)
            );
        };
    }
}
