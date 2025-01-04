package com.example.sharebite.dto;

import com.example.sharebite.entity.Address;
import com.example.sharebite.entity.ContributorType;
import jakarta.validation.constraints.*;
import java.util.Objects;

public class ContributorDTO {

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only alphabets and spaces")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    private String name;

    @NotBlank(message = "Username is required")
    @Pattern(regexp = "^[A-Za-z0-9_@.]+$", message = "Username can contain alphabets, numbers, and special characters like '_', '@', and '.'")
    @Size(max = 25, message = "Username must not exceed 25 characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^[A-Za-z0-9@_.]+$", message = "Password must be alphanumeric")
    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")
    private String password;

    @NotNull(message = "Address is required")
    private AddressDTO address;

    @NotNull(message = "Contributor Type is required")
    private ContributorTypeDTO contributorType;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Phone number must be 10 digits")
    private String phoneNo;

    @Pattern(regexp = "^[7-9][0-9]{9}$", message = "Alternate phone number must be 10 digits")
    private String alternatePhoneNo;

    // Default constructor
    public ContributorDTO() {
    }

    // Parameterized constructor
    public ContributorDTO(String name, String username, String email, String password, AddressDTO address, ContributorTypeDTO contributorType, String phoneNo, String alternatePhoneNo) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contributorType = contributorType;
        this.phoneNo = phoneNo;
        this.alternatePhoneNo = alternatePhoneNo;
    }

    // Getters and Setters
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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ContributorTypeDTO getContributorType() {
        return contributorType;
    }

    public void setContributorType(ContributorTypeDTO contributorType) {
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
        ContributorDTO that = (ContributorDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(address, that.address) &&
                Objects.equals(contributorType, that.contributorType) &&
                Objects.equals(phoneNo, that.phoneNo) &&
                Objects.equals(alternatePhoneNo, that.alternatePhoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, email, password, address, contributorType, phoneNo, alternatePhoneNo);
    }

    // toString method
    @Override
    public String toString() {
        return "ContributorDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", contributorType=" + contributorType +
                ", phoneNo='" + phoneNo + '\'' +
                ", alternatePhoneNo='" + alternatePhoneNo + '\'' +
                '}';
    }
}
