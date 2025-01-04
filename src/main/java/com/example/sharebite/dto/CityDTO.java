package com.example.sharebite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class CityDTO {

    private Integer cityId;

    @NotNull(message = "State cannot be null")
    private StateDTO state;

    @NotNull(message = "City name cannot be null")
    @Size(min = 3, max = 50, message = "City name must be between 3 and 50 characters")
    private String name;

    private List<PincodeDTO> pincodes;
    private List<AddressDTO> addresses;

    // Default constructor
    public CityDTO() {
    }

    // All-args constructor
    public CityDTO(Integer cityId, StateDTO state, String name, List<PincodeDTO> pincodes, List<AddressDTO> addresses) {
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

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PincodeDTO> getPincodes() {
        return pincodes;
    }

    public void setPincodes(List<PincodeDTO> pincodes) {
        this.pincodes = pincodes;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
