package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Integer addressId;

    @ManyToOne
    @JoinColumn(name = "pincode_id", nullable = false)
    @JsonBackReference
    private Pincode pincode;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    // Default Constructor
    public Address() {
    }

    // All-args Constructor
    public Address(Integer addressId, City city, Pincode pincode, String address) {
        this.addressId = addressId;
        this.city = city;
        this.pincode = pincode;
        this.address = address;
    }

    // Getters and Setters
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
