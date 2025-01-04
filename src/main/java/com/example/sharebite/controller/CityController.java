package com.example.sharebite.controller;

import com.example.sharebite.entity.City;
import com.example.sharebite.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;


    @GetMapping("")
    public List<City> getCitiesByCountryAndState(@RequestParam("state") String state, @RequestParam("country") String country) {
        return cityService.findCityByStateAndCountry(state, country);
    }
}
