package com.example.sharebite.controller;

import com.example.sharebite.entity.State;
import com.example.sharebite.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping("")
    public List<State> getAllStates(@RequestParam("country") String country) {
        return stateService.findStatesByCountry(country);
    }
}
