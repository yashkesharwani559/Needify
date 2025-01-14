package com.example.sharebite.repository;

import com.example.sharebite.entity.User;
import com.example.sharebite.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The repository interface for the 'users' entity
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Custom query methods can be defined here if necessary, for example:
    // Method to find a User by their email
    User findByEmail(String email);

    List<User> getAllUserByUserType(UserType userType);

//    List<User> findByAddressId(int addressId);
}
