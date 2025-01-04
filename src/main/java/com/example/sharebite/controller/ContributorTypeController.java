package com.example.sharebite.controller;

import com.example.sharebite.entity.ContributorType;
import com.example.sharebite.service.ContributorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/contributor-types")
public class ContributorTypeController {
    @Autowired
    private ContributorTypeService contributorTypeService;

    @GetMapping("")
    public List<ContributorType> getAll(){
        return contributorTypeService.getAll();
    }
}
