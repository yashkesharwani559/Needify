package com.example.sharebite.service;

import com.example.sharebite.entity.Address;
import com.example.sharebite.entity.City;
import com.example.sharebite.entity.Pincode;
import com.example.sharebite.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findOrCreateAddress(City city, Pincode pincode, String name){
        try{
            return addressRepository.findByCityAndPincodeAndAddress(city, pincode, name).orElseThrow(() -> new IllegalArgumentException());
        }catch (IllegalArgumentException e){
            Address address = new Address();
            address.setCity(city);
            address.setPincode(pincode);
            address.setAddress(name);
            return addressRepository.save(address);
        }
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }
}
