package com.example.sharebite.service;

import com.example.sharebite.entity.ContributorType;
import com.example.sharebite.repository.ContributorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;

@Service
public class ContributorTypeService {
    @Autowired
    private ContributorTypeRepository contributorTypeRepository;

    public ContributorType findByName(String name){return contributorTypeRepository.findByName(name);}

    public List<ContributorType> getAll(){return contributorTypeRepository.findAll();}

}
