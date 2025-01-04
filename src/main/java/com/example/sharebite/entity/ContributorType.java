package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contributor_types")
public class ContributorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contributorTypeId;

    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @OneToMany(mappedBy = "contributorType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Contributor> contributors;

    // Default Constructor
    public ContributorType() {
    }

    // All-args Constructor
    public ContributorType(Integer contributorTypeId, String name, List<Contributor> contributors) {
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

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContributorType that = (ContributorType) o;
        return contributorTypeId.equals(that.contributorTypeId) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contributorTypeId, name);
    }

    // toString method
    @Override
    public String toString() {
        return "ContributorType{" +
                "contributorTypeId=" + contributorTypeId +
                ", name='" + name + '\'' +
                ", contributors=" + contributors +
                '}';
    }
}
