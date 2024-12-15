package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    @JsonBackReference
    private State state;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pincode> pincodes;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Address> addresses;

    // Default Constructor
    public City() {
    }

    // All-args Constructor
    public City(Integer cityId, State state, String name, List<Pincode> pincodes, List<Address> addresses) {
        this.cityId = cityId;
        this.state = state;
        this.name = name;
        this.pincodes = pincodes;
        this.addresses = addresses;
    }

    // Getters and Setters
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pincode> getPincodes() {
        return pincodes;
    }

    public void setPincodes(List<Pincode> pincodes) {
        this.pincodes = pincodes;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
