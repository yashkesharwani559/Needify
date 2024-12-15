package com.example.sharebite.service;

import com.example.sharebite.entity.Country;
import com.example.sharebite.entity.State;
import com.example.sharebite.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<State> findAll() {return stateRepository.findAll();}

    public Optional<State> findStateByName(String name){
        return stateRepository.findByName(name);
    }

    public Optional<State> findStateByCountryAndName(Country country, String name){
        return stateRepository.findByCountryAndName(country, name);
    }

}
