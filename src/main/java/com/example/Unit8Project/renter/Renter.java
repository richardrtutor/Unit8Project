package com.example.Unit8Project.renter;

import com.example.Unit8Project.apartment.Apartment;

import javax.persistence.*;

@Entity
@Table
public class Renter {

    @Id
    @SequenceGenerator(
            name = "renter_sequence",
            sequenceName = "renter_sequence",
            allocationSize = 1
    )
    
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "renter_sequence"
    ) private Long id;
    private String renter_name;
    private String renter_number;
    private String renter_email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;

    public Renter() {}

    public Renter(Long id, String renter_name, String renter_number, String renter_email) {
        this.id = id;
        this.renter_name = renter_name;
        this.renter_number = renter_number;
        this.renter_email = renter_email;

    }

    public Renter( String renter_name, String renter_number, String renter_email) {
        this.renter_name = renter_name;
        this.renter_number = renter_number;
        this.renter_email = renter_email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return renter_name;
    }

    public void setName(String renter_name) {
        this.renter_name = renter_name;
    }

    public String getNumber() {
        return renter_number;
    }

    public void setNumber(String renter_number) {
        this.renter_number = renter_number;
    }

    public String getEmail() {
        return renter_email;
    }

    public void setEmail(String renter_email) {
        this.renter_email = renter_email;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "id=" + id +
                ", renter_name='" + renter_name + '\'' +
                ", renter_number='" + renter_number + '\'' +
                ", renter_email='" + renter_email + '\'' +
                '}';
    }
}
