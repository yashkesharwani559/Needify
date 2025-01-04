package com.example.sharebite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class StateDTO {

    private Integer stateId;

    @NotNull(message = "Country cannot be null")
    private CountryDTO country;

    @NotNull(message = "State name cannot be null")
    @Size(min = 3, max = 50, message = "State name must be between 3 and 50 characters")
    private String name;

    private List<CityDTO> cities;

    // Default constructor
    public StateDTO() {
    }

    // All-args constructor
    public StateDTO(Integer stateId, CountryDTO country, String name, List<CityDTO> cities) {
        this.stateId = stateId;
        this.country = country;
        this.name = name;
        this.cities = cities;
    }

    // Getters and Setters
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }
}
