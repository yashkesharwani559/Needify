package com.example.sharebite.service;

import com.example.sharebite.entity.Contributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sharebite.repository.ContributorRepository;

import java.util.List;

@Service
public class ContributorService {
    @Autowired
    private ContributorRepository contributorRepository;

    public List<Contributor> getAllContributors(){
        return contributorRepository.findAll();
    }
}
