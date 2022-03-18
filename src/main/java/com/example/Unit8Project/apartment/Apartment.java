package com.example.Unit8Project.apartment;
import com.example.Unit8Project.renter.Renter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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
    ) private Long apartment_id;

    @JsonIgnore
    @OneToMany(mappedBy = "apartments")
    private Set<Renter> renterSet;

    private String apartment_address;
    private Integer apartment_cost;
    private Integer apartment_sqft;

    public Apartment() {
    }

    public Apartment(Long apartment_id, String apartment_address, Integer apartment_cost, Integer apartment_sqft) {
        this.apartment_id = apartment_id;
        this.apartment_address = apartment_address;
        this.apartment_cost = apartment_cost;
        this.apartment_sqft = apartment_sqft;
    }

    public Apartment(String apartment_address, Integer apartment_cost, Integer apartment_sqft) {
        this.apartment_address = apartment_address;
        this.apartment_cost = apartment_cost;
        this.apartment_sqft = apartment_sqft;
    }

    public Set<Renter> getRenterSet() {
        return this.renterSet;
    }

    public Long getId() {
        return apartment_id;
    }

    public void setId(Long apartment_id) {
        this.apartment_id = apartment_id;
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
                "apartment_id=" + apartment_id +
                ", apartment_address='" + apartment_address + '\'' +
                ", apartment_cost=" + apartment_cost +
                ", apartment_sqft=" + apartment_sqft +
                '}';
    }
}
