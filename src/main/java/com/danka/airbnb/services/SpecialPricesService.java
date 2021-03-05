/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.services;

import com.danka.airbnb.EntityNotFoundException;
import com.danka.airbnb.repositories.SpecialPricesRepository;
import com.danka.airbnb.models.SpecialPrices;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class SpecialPricesService {

    @Autowired
    private SpecialPricesRepository specialPricesRepository;

    public List<SpecialPrices> findAll(){
        return (List<SpecialPrices>) specialPricesRepository.findAll();
    }

    public SpecialPrices findById(UUID id){
        return specialPricesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public SpecialPrices save(SpecialPrices special){
        return specialPricesRepository.save(special);
    }

    public void deleteById(UUID id){
        specialPricesRepository.deleteById(id);
    }

}
