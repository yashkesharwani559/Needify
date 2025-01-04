package com.example.sharebite.service;

import com.example.sharebite.entity.UserType;
import com.example.sharebite.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public UserType getUserTypeByName(String name){
        return userTypeRepository.getUserTypeByName(name);
    }
}
