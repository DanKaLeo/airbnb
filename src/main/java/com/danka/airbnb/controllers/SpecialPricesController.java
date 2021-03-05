/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.controllers;

import com.danka.airbnb.models.SpecialPrices;
import com.danka.airbnb.services.SpecialPricesService;
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
@RequestMapping("/api/special")
public class SpecialPricesController {

    @Autowired
    private SpecialPricesService specialPricesService;

    @GetMapping
    public List<SpecialPrices> findAll(){
        return specialPricesService.findAll();
    }

    @GetMapping("/{id}")
    public SpecialPrices findById(@PathVariable UUID id){
        return specialPricesService.findById(id);
    }

    @PostMapping
    public SpecialPrices create(@RequestBody SpecialPrices special){
        return specialPricesService.save(special);
    }

    @PutMapping("/{id}")
    public SpecialPrices update(@RequestBody SpecialPrices special){
        return specialPricesService.save(special);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        specialPricesService.deleteById(id);
    } 
    
}
