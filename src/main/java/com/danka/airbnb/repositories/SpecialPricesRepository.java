/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.repositories;

import com.danka.airbnb.models.SpecialPrices;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daniel
 */
@Repository
public interface SpecialPricesRepository extends CrudRepository<SpecialPrices, UUID>{}
