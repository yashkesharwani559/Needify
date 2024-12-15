package com.example.sharebite.service;

import com.example.sharebite.entity.City;
import com.example.sharebite.entity.State;
import com.example.sharebite.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {return cityRepository.findAll();}

    public Optional<City> findCityByNameAndState(State state, String name){
        return cityRepository.findByStateAndName(state,name);
    }
}
