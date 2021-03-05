/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.controllers;

import com.danka.airbnb.models.Listings;
import com.danka.airbnb.models.ObjRequestBody;
import com.danka.airbnb.models.ObjResponse;
import com.danka.airbnb.models.ObjResponseError;
import com.danka.airbnb.services.ListingsService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author daniel
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/list")
public class ListingsController {

    @Autowired
    private ListingsService listService;

    @GetMapping
    public List<Listings> findAll(){
        return listService.findAll();
    }

    @GetMapping("/{id}")
    public Listings findById(@PathVariable UUID id){
        return listService.findById(id);
    }

    @PostMapping
    public Listings create(@RequestBody Listings list){
        return listService.save(list);
    }

    @PutMapping("/{id}")
    public Listings update(@RequestBody Listings list){
        return listService.save(list);
    }

    @DeleteMapping("/{id}")
    public ObjResponseError deleteById(@PathVariable UUID id){
        return listService.deleteById(id);
    } 
    
    @PostMapping("/checkout")
    @ResponseBody
    public ObjResponse checkout(@RequestBody ObjRequestBody objeto ){
        return listService.checkout(objeto);
    }    
}

