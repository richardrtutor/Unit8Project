package com.example.Unit8Project.apartment;

import com.example.Unit8Project.renter.Renter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table
public class Apartment {
    
    @Id
    @SequenceGenerator(
            name = "apartment_sequence",
            sequenceName = "apartment_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "apartment_sequence"
    ) private Long id;

    @JsonIgnore
    @OneToOne
    private Renter renter;

    private String name;
    private String apartment_address;
    private Integer apartment_cost;
    private Integer apartment_sqft;

    public Apartment() {
    }

    public Apartment(Long id, Renter renter, String name, String apartment_address, Integer apartment_cost, Integer apartment_sqft) {
        this.id = id;
        this.renter = renter;
        this.name = name;
        this.apartment_address = apartment_address;
        this.apartment_cost = apartment_cost;
        this.apartment_sqft = apartment_sqft;
    }

    public Apartment(Renter renter, String name, String apartment_address, Integer apartment_cost, Integer apartment_sqft) {
        this.renter = renter;
        this.name = name;
        this.apartment_address = apartment_address;
        this.apartment_cost = apartment_cost;
        this.apartment_sqft = apartment_sqft;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Renter getRenter() {return renter;}

    public void setRenter(Renter renter) {this.renter = renter;}

    public Long getId() {return id;}

    public void setId(Long apartment_id) {
        this.id = id;
    }

    public String getAddress() {
        return apartment_address;
    }

    public void setAddress(String apartment_address) {
        this.apartment_address = apartment_address;
    }

    public Integer getCost() {
        return apartment_cost;
    }

    public void setCost(Integer apartment_cost) {
        this.apartment_cost = apartment_cost;
    }

    public Integer getSqft() {
        return apartment_sqft;
    }

    public void setSqft(Integer apartment_sqft) {
        this.apartment_sqft = apartment_sqft;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", renter=" + renter +
                ", name='" + name + '\'' +
                ", apartment_address='" + apartment_address + '\'' +
                ", apartment_cost=" + apartment_cost +
                ", apartment_sqft=" + apartment_sqft +
                '}';
    }


}
