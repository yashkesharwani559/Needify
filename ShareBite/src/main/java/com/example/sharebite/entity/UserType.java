package com.example.sharebite.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_types")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userTypeId;

    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<User> users;

    // Default Constructor
    public UserType() {
    }

    // All-args Constructor
    public UserType(Integer userTypeId, String name, List<User> users) {
        this.userTypeId = userTypeId;
        this.name = name;
        this.users = users;
    }

    // Getters and Setters
    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
