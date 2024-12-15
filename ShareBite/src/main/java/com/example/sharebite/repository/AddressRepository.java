package com.example.sharebite.repository;

import com.example.sharebite.entity.Address;
import com.example.sharebite.entity.City;
import com.example.sharebite.entity.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAll();

    Optional<Address> findByCityAndPincodeAndAddress(City city, Pincode pincode, String address);

    Address save(Address address);

}
