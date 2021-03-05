/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.controllers;

import com.danka.airbnb.models.Users;
import com.danka.airbnb.services.UsersService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daniel
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersService userService;

    @GetMapping
    public List<Users> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable UUID id){
        return userService.findById(id);
    }

    @PostMapping
    public Users create(@RequestBody Users user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public Users update(@RequestBody Users user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        userService.deleteById(id);
    } 
}
