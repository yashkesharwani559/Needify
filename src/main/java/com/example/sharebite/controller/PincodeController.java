package com.example.sharebite.controller;

import com.example.sharebite.entity.Pincode;
import com.example.sharebite.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("api/pincodes")
@RestController
public class PincodeController {
    @Autowired
    private PincodeService pincodeService;

    @GetMapping("")
    public List<Pincode> getPincodes(@RequestParam String city, @RequestParam String state, @RequestParam String country){
        return pincodeService.findPincodeByCityStateCountry(city, state, country);
    }
}
