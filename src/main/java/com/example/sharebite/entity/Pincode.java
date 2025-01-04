package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "pincodes")
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pincodeId;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonBackReference
    private City city;

    @Column(name = "pincode", nullable = false, unique = true, length = 6)
    private String pincode;

    // Default Constructor
    public Pincode() {
    }

    // All-args Constructor
    public Pincode(Integer pincodeId, City city, String pincode) {
        this.pincodeId = pincodeId;
        this.city = city;
        this.pincode = pincode;
    }

    // Getters and Setters
    public Integer getPincodeId() {
        return pincodeId;
    }

    public void setPincodeId(Integer pincodeId) {
        this.pincodeId = pincodeId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
