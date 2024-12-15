package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    @JsonBackReference
    private Address address;

    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    @JsonBackReference
    private UserType userType;

    @Column(name = "phone_no", nullable = false, length = 10)
    private String phoneNo;

    @Column(name = "alternate_phone_no", length = 10)
    private String alternatePhoneNo;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String name, String email, String password, Address address, UserType userType, String phoneNo, String alternatePhoneNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userType = userType;
        this.phoneNo = phoneNo;
        this.alternatePhoneNo = alternatePhoneNo;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(address, user.address) &&
                Objects.equals(userType, user.userType) &&
                Objects.equals(phoneNo, user.phoneNo) &&
                Objects.equals(alternatePhoneNo, user.alternatePhoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, address, userType, phoneNo, alternatePhoneNo);
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", userType=" + userType +
                ", phoneNo='" + phoneNo + '\'' +
                ", alternatePhoneNo='" + alternatePhoneNo + '\'' +
                '}';
    }
}



//package com.example.sharebite.entity;
//
//import jakarta.persistence.*;
//import java.util.Objects;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private int userId;
//
//    @Column(name = "name", nullable = false, length = 50)
//    private String name;
//
//    @Column(name = "email", nullable = false, unique = true, length = 255)
//    private String email;
//
//    @Column(name = "password", nullable = false, length = 255)
//    private String password;
//
//    @Column(name = "address_id", nullable = false)
//    private int addressId;
//
//    @Column(name = "user_type_id", nullable = false)
//    private int userTypeId;
//
//    @Column(name = "phone_no", nullable = false, length = 10)
//    private String phoneNo;
//
//    @Column(name = "alternate_phone_no", length = 10)
//    private String alternatePhoneNo;
//
//    // Default constructor
//    public User() {
//    }
//
//    // Parameterized constructor
//    public User(String name, String email, String password, int addressId, int userTypeId, String phoneNo, String alternatePhoneNo) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.addressId = addressId;
//        this.userTypeId = userTypeId;
//        this.phoneNo = phoneNo;
//        this.alternatePhoneNo = alternatePhoneNo;
//    }
//
//    // Getters and Setters
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(int addressId) {
//        this.addressId = addressId;
//    }
//
//    public int getUserTypeId() {
//        return userTypeId;
//    }
//
//    public void setUserTypeId(int userTypeId) {
//        this.userTypeId = userTypeId;
//    }
//
//    public String getPhoneNo() {
//        return phoneNo;
//    }
//
//    public void setPhoneNo(String phoneNo) {
//        this.phoneNo = phoneNo;
//    }
//
//    public String getAlternatePhoneNo() {
//        return alternatePhoneNo;
//    }
//
//    public void setAlternatePhoneNo(String alternatePhoneNo) {
//        this.alternatePhoneNo = alternatePhoneNo;
//    }
//
//    // Override equals and hashCode
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return userId == user.userId && addressId == user.addressId && userTypeId == user.userTypeId && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phoneNo, user.phoneNo) && Objects.equals(alternatePhoneNo, user.alternatePhoneNo);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId, name, email, password, addressId, userTypeId, phoneNo, alternatePhoneNo);
//    }
//
//    // toString method
//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", addressId=" + addressId +
//                ", userTypeId=" + userTypeId +
//                ", phoneNo='" + phoneNo + '\'' +
//                ", alternatePhoneNo='" + alternatePhoneNo + '\'' +
//                '}';
//    }
//}



