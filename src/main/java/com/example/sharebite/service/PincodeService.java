package com.example.sharebite.service;

import com.example.sharebite.entity.City;
import com.example.sharebite.entity.Country;
import com.example.sharebite.entity.Pincode;
import com.example.sharebite.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sharebite.repository.PincodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PincodeService {
    @Autowired
    private PincodeRepository pincodeRepository;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    public List<Pincode> findAll(){return pincodeRepository.findAll();}

    public Optional<Pincode> findPincodeByCityAndName(City city, String name){
        return pincodeRepository.findByCityAndPincode(city, name);
    }

    public List<Pincode> findPincodeByCityStateCountry(String city, String state, String country){

        Country country1 = countryService.findByName(country);
        State state1 = stateService.findStateByCountryAndName(country1, state).orElse(null);

        City city1 = cityService.findCityByNameAndState(state1, city).orElse(null);

        return pincodeRepository.findByCity(city1);
    }

}
