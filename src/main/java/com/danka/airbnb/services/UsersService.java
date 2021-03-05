/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.services;

import com.danka.airbnb.EntityNotFoundException;
import com.danka.airbnb.repositories.UsersRepository;
import com.danka.airbnb.models.Users;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll(){
        return (List<Users>) usersRepository.findAll();
    }

    public Users findById(UUID id){
        return usersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Users save(Users user){
        return usersRepository.save(user);
    }

    public void deleteById(UUID id){
        usersRepository.deleteById(id);
    }

}

