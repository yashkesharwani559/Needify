package com.example.sharebite.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class ContributorTypeDTO {

    private Integer contributorTypeId;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 80, message = "Name cannot exceed 80 characters")
    private String name;

    private List<ContributorDTO> contributors;

    // Default Constructor
    public ContributorTypeDTO() {
    }

    // All-args Constructor
    public ContributorTypeDTO(Integer contributorTypeId, String name, List<ContributorDTO> contributors) {
        this.contributorTypeId = contributorTypeId;
        this.name = name;
        this.contributors = contributors;
    }

    // Getters and Setters
    public Integer getContributorTypeId() {
        return contributorTypeId;
    }

    public void setContributorTypeId(Integer contributorTypeId) {
        this.contributorTypeId = contributorTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContributorDTO> getContributors() {
        return contributors;
    }

    public void setContributors(List<ContributorDTO> contributors) {
        this.contributors = contributors;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContributorTypeDTO that = (ContributorTypeDTO) o;
        return contributorTypeId.equals(that.contributorTypeId) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contributorTypeId, name);
    }

    // toString method
    @Override
    public String toString() {
        return "ContributorTypeDTO{" +
                "contributorTypeId=" + contributorTypeId +
                ", name='" + name + '\'' +
                ", contributors=" + contributors +
                '}';
    }
}
