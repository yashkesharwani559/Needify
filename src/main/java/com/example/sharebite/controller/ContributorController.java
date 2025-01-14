package com.example.sharebite.controller;

import com.example.sharebite.dto.ContributorDTO;
import com.example.sharebite.entity.Contributor;
import com.example.sharebite.service.ContributorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contributors")
public class ContributorController {
    @Autowired
    private ContributorService contributorService;


    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@Valid @RequestBody ContributorDTO contributorDTO) {
        try{
            return ResponseEntity.ok(contributorService.saveContributor(contributorDTO));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error saving user"+e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String all, @RequestParam("password") String password) {
        try{
            return ResponseEntity.ok(contributorService.findContributor(all, password));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error login user"+e.getMessage());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteContributor(@RequestParam String all, @RequestParam("password") String password) {
        try{
            if(contributorService.deleteContributor(all, password)){
                return ResponseEntity.ok("Contributor Successfully deleted");
            }else{
                return ResponseEntity.badRequest().body("Wrong Credentials");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error deleting user"+e.getMessage());
        }
    }

}
