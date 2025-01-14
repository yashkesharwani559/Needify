package com.example.sharebite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PincodeDTO {

    private Integer pincodeId;

    @NotNull(message = "City cannot be null")
    private CityDTO city;

    @NotNull(message = "Pincode cannot be null")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be a 6-digit number")
    private String pincode;

    // Default constructor
    public PincodeDTO() {
    }

    // All-args constructor
    public PincodeDTO(Integer pincodeId, CityDTO city, String pincode) {
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

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
