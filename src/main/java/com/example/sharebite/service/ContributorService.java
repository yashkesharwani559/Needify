package com.example.sharebite.service;

import com.example.sharebite.entity.Contributor;
import com.example.sharebite.dto.*;
import com.example.sharebite.mapper.ContributorMapper;
import com.example.sharebite.utils.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sharebite.repository.ContributorRepository;

import java.util.List;
import com.example.sharebite.utils.PhoneNumber;

@Service
public class ContributorService {
    @Autowired
    private ContributorRepository contributorRepository;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private ContributorMapper contributorMapper;
    @Autowired
    private ContributorTypeService contributorTypeService;
    @Autowired
    private AddressService addressService;

    public List<Contributor> getAllContributors(){
        return contributorRepository.findAll();
    }


    public String saveContributor(ContributorDTO contributorDTO) {
        if(contributorDTO == null){
            return "Contributor not recieved";
        }else if(contributorRepository.findByEmail(contributorDTO.getEmail()).isPresent()){
            return "Email already in use";
        }else if(contributorRepository.findByUsername(contributorDTO.getUsername()).isPresent()){
            return "Username already in use";
        }else if(contributorRepository.findByPhoneNo(contributorDTO.getPhoneNo()).isPresent()){
            return "Phone number already in use";
        }else{
            Contributor contributor = contributorMapper.toEntity(contributorDTO);
            contributor.setPassword(passwordService.encode(contributor.getPassword()));

            contributor.setContributorType(contributorTypeService.findByName(contributor.getContributorType().getName()));
            contributor.setAddress(addressService.findOrCreateAddress(contributor.getAddress().getCity(), contributor.getAddress().getPincode(), contributor.getAddress().getAddress()));
            contributorRepository.save(contributor);
            return "contributor saved successfully";
        }
    }



    public Contributor findContributor(String email, String password){
        Contributor contributor = null;
        if(PhoneNumber.isValidPhoneNumber(email)){
            contributor = contributorRepository.findByPhoneNo(email).orElse(null);
        }else if(EmailValidator.isValidEmail(email)){
            contributor = contributorRepository.findByEmail(email).orElse(null);
        }else{
            contributor = contributorRepository.findByUsername(email).orElse(null);
        }

        if(contributor != null && passwordService.verify(password, contributor.getPassword())){
            return contributor;
        }else{
            return null;
        }
    }

    public boolean deleteContributor(String email, String password){
        Contributor contributor = findContributor(email, password);
        if(contributor != null){
            contributorRepository.delete(contributor);
            return true;
        }else{
            return false;
        }
    }

}
