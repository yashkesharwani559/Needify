package com.example.sharebite.service;

import com.example.sharebite.entity.Country;
import com.example.sharebite.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll() {return countryRepository.findAll();}

    public Optional<Country> findCountryByName(String name) {
        return countryRepository.findByName(name);
    }
}
