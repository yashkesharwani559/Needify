package com.example.sharebite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddressDTO {

    private Integer addressId;

    @NotNull(message = "City cannot be null")
    private CityDTO city;

    @NotNull(message = "Pincode cannot be null")
    private PincodeDTO pincode;

    @NotNull(message = "Address cannot be null")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

    // Default constructor
    public AddressDTO() {
    }

    // All-args constructor
    public AddressDTO(Integer addressId, CityDTO city, PincodeDTO pincode, String address) {
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

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public PincodeDTO getPincode() {
        return pincode;
    }

    public void setPincode(PincodeDTO pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
