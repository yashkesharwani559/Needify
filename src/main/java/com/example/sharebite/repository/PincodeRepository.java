package com.example.sharebite.repository;

import com.example.sharebite.entity.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sharebite.entity.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface PincodeRepository extends JpaRepository<Pincode, Integer> {
    List<Pincode> findAll();

    Optional<Pincode> findByCityAndPincode(City city, String pincode);

    List<Pincode> findByCity(City city);
}
