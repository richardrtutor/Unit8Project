package com.example.Unit8Project.landlord;

import javax.persistence.*;

@Entity
@Table
public class Landlord {

    @Id
    @SequenceGenerator(
            name = "landlord_sequence",
            sequenceName = "landlord_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "landlord_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private String add;

    public Landlord() {
    }

    public Landlord(Long id, String landlord_name, String landlord_email, String landlord_address) {
        this.id = id;
        this.landlord_name = landlord_name;
        this.landlord_email = landlord_email;
        this.landlord_address = landlord_address;
    }

    public Landlord(String landlord_name, String landlord_email, String landlord_address) {
        this.landlord_name = landlord_name;
        this.landlord_email = landlord_email;
        this.landlord_address = landlord_address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return landlord_name;
    }

    public void setName(String landlord_name) {
        this.landlord_name = landlord_name;
    }

    public String getEmail() {
        return landlord_email;
    }

    public void setEmail(String landlord_email) {
        this.landlord_email = landlord_email;
    }

    public String getAdd() {
        return landlord_address;
    }

    public void setAdd(String landlord_address) {
        this.landlord_address = landlord_address;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "id=" + id +
                ", landlord_name='" + landlord_name + '\'' +
                ", landlord_email='" + landlord_email + '\'' +
                ", landlord_address='" + landlord_address + '\'' +
                '}';
    }
}
