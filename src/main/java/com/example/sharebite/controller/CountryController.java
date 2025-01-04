package com.example.sharebite.controller;

import com.example.sharebite.entity.Country;
import com.example.sharebite.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
