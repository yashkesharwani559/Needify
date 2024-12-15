package com.example.sharebite.service;

import com.example.sharebite.entity.City;
import com.example.sharebite.entity.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sharebite.repository.PincodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PincodeService {
    @Autowired
    private PincodeRepository pincodeRepository;

    public List<Pincode> findAll(){return pincodeRepository.findAll();}

    public Optional<Pincode> findPincodeByCityAndName(City city, String name){
        return pincodeRepository.findByCityAndPincode(city, name);
    }

}
