package com.example.Unit8Project.landlord;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LandlordConfig {

    @Bean
    CommandLineRunner commandLineRunner(LandlordRepository repository) {
        return args -> {
            Landlord Rich = new Landlord("Richard", "RichR@gmail.com", "3507 HWY 96 Eckford");
            Landlord Bonk = new Landlord("Wackus", "Wackus@Bonkusmail.com", "Rome");

            repository.saveAll(
                    List.of(Rich, Bonk)
            );
        };
    }
}
