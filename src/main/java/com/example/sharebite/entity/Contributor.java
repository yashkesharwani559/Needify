package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "contributors")
public class Contributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contributor_id")
    private int contributorId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name= "username", nullable = false, length=25)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", nullable = false)
    @JsonBackReference
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contributor_type_id", nullable = false)
    @JsonBackReference
    private ContributorType contributorType;

    @Column(name = "phone_no", nullable = false, length = 10)
    private String phoneNo;

    @Column(name = "alternate_phone_no", length = 10)
    private String alternatePhoneNo;

    // Default constructor
    public Contributor() {
    }

    // Parameterized constructor
    public Contributor(String name, String email, String password, Address address, ContributorType contributorType, String phoneNo, String alternatePhoneNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contributorType = contributorType;
        this.phoneNo = phoneNo;
        this.alternatePhoneNo = alternatePhoneNo;
    }

    // Getters and Setters
    public int getContributorId() {
        return contributorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContributorId(int contributorId) {
        this.contributorId = contributorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContributorType getContributorType() {
        return contributorType;
    }

    public void setContributorType(ContributorType contributorType) {
        this.contributorType = contributorType;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAlternatePhoneNo() {
        return alternatePhoneNo;
    }

    public void setAlternatePhoneNo(String alternatePhoneNo) {
        this.alternatePhoneNo = alternatePhoneNo;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contributor that = (Contributor) o;
        return contributorId == that.contributorId &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(address, that.address) &&
                Objects.equals(contributorType, that.contributorType) &&
                Objects.equals(phoneNo, that.phoneNo) &&
                Objects.equals(alternatePhoneNo, that.alternatePhoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contributorId, name, email, password, address, contributorType, phoneNo, alternatePhoneNo);
    }

    // toString method
    @Override
    public String toString() {
        return "Contributor{" +
                "contributorId=" + contributorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", contributorType=" + contributorType +
                ", phoneNo='" + phoneNo + '\'' +
                ", alternatePhoneNo='" + alternatePhoneNo + '\'' +
                '}';
    }
}
