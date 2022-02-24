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

    public Landlord(Long id, String name, String email, String add) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.add = add;
    }

    public Landlord(String name, String email, String add) {
        this.name = name;
        this.email = email;
        this.add = add;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Landlord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
