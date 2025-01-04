package com.example.sharebite.service;

import com.example.sharebite.entity.*;
import com.example.sharebite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @Autowired
    private CityService cityService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PincodeService pincodeService;


    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private PasswordService passwordService;


    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsersByUserType(String name) {
        UserType userType1 = userTypeService.getUserTypeByName(name);
        return userRepository.getAllUserByUserType(userType1);
    }

//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }


    public User saveUserWithEntities(String name, String email, String password, String userType, String phone, String aphone, String country, String state, String city, String pincode, String address) {

        User user = createUser(name, email, password, userType, phone, aphone, country, state, city, pincode, address);

        return userRepository.save(user);
    }


    public User createUser(String name, String email, String password, String userType, String phone, String aphone, String country, String state, String city, String pincode, String address){
        Country country1 = countryService.findCountryByName(country).orElseThrow(() -> new IllegalArgumentException("Country not found"+country));
        State state1 = stateService.findStateByCountryAndName(country1, state).orElseThrow(() -> new IllegalArgumentException("State not found"+state));
        City city1 = cityService.findCityByNameAndState(state1, city).orElseThrow(() -> new IllegalArgumentException("City not found "+city));
        Pincode pincode1 = pincodeService.findPincodeByCityAndName(city1, pincode).orElseThrow(() -> new IllegalArgumentException("Pincode not found "+pincode));
        Address address1 = addressService.findOrCreateAddress(city1, pincode1, address.toLowerCase());
        UserType userType1 = userTypeService.getUserTypeByName(userType);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        password = passwordService.encode(password);
        user.setPassword(password);
        user.setUserType(userType1);
        user.setAddress(address1);
        user.setPhoneNo(phone);
        user.setAlternatePhoneNo(aphone);

        return user;
    }

    public boolean deleteUser(){
        return true;
    }
}
