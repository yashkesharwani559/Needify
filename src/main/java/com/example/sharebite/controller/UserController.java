
package com.example.sharebite.controller;

import com.example.sharebite.entity.*;
import com.example.sharebite.service.UserService;
import com.example.sharebite.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
//@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContributorService contributorService;

    // Endpoint to get a user by email
    @GetMapping("/email")
    public User getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/usertype")
    public List<User> getAllUsersByUserType(@RequestParam("usertype") String name){
        return userService.getAllUsersByUserType(name);
    }

    @GetMapping("/contributor")
    public List<Contributor> getAllContributors(){
        return contributorService.getAllContributors();
    }



    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam String usertype, @RequestParam String phone, @RequestParam(required = false) String aphone, @RequestParam String address, @RequestParam String city, @RequestParam String state, @RequestParam String country, @RequestParam String pincode) {
        try{
            User user = userService.saveUserWithEntities(name, email, password, usertype, phone, aphone, country, state, city, pincode, address);

            return ResponseEntity.ok(user);

        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error saving user"+e.getMessage());
        }
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam("email") String email) {
        try{

            User user = userService.getUserByEmail(email);
            if(userService.deleteUser())
                return ResponseEntity.ok(user);
            else
                return ResponseEntity.badRequest().body("User not deleted");
                
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error deleting user"+e.getMessage());
        }
    }

}
