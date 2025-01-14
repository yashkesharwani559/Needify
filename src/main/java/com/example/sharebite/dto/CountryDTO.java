package com.example.sharebite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class CountryDTO {

    private Integer countryId;

    @NotNull(message = "Country name cannot be null")
    @Size(min = 2, max = 50, message = "Country name must be between 2 and 50 characters")
    private String name;

    private List<StateDTO> states;  // List of states associated with the country

    // Default Constructor
    public CountryDTO() {
    }

    // Constructor with parameters
    public CountryDTO(Integer countryId, String name, List<StateDTO> states) {
        this.countryId = countryId;
        this.name = name;
        this.states = states;
    }

    // Getters and Setters
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StateDTO> getStates() {
        return states;
    }

    public void setStates(List<StateDTO> states) {
        this.states = states;
    }
}
