/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.services;

import com.danka.airbnb.EntityNotFoundException;
import com.danka.airbnb.repositories.ListingsRepository;
import com.danka.airbnb.models.Listings;
import com.danka.airbnb.models.ObjRequestBody;
import com.danka.airbnb.models.ObjResponse;
import com.danka.airbnb.models.ObjResponseCheckout;
import com.danka.airbnb.models.ObjResponseError;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class ListingsService {

    @Autowired
    private ListingsRepository listingRepository;

    public List<Listings> findAll() {
        return (List<Listings>) listingRepository.findAll();
    }

    public Listings findById(UUID id) {
        return listingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Listings save(Listings list) {
        return listingRepository.save(list);
    }

    public ObjResponseError deleteById(UUID id) {
        try {
            listingRepository.deleteById(id);
        } catch (Exception ex) {
            return new ObjResponseError(false, "Error en delete");
        }
        return new ObjResponseError(true, "Se borro " + id);
    }

    public ObjResponse checkout(ObjRequestBody objeto) {

        Listings list = null;
        try {
            list = this.findById(UUID.fromString(objeto.getId()));
        } catch (Exception ex) {
            return new ObjResponseError(false, "Error de casa");
        }

        if (list != null) {

            Double total = 0D;
            LocalDate hoy = LocalDate.now();
            LocalDate desde = LocalDate.parse(objeto.getCheckIn(), DateTimeFormatter.ISO_DATE);
            LocalDate hasta = LocalDate.parse(objeto.getCheckOut(), DateTimeFormatter.ISO_DATE);
            Long estadia = DAYS.between(desde, hasta);
            Double descuento = 0D;
            System.out.println("Hoy:" + hoy);
            System.out.println("Desde:" + desde);
            System.out.println("Hasta:" + hasta);
            System.out.println("Casa:" + list.getId());

            if (desde.isBefore(hoy) || hasta.isBefore(hoy)) {
                return new ObjResponseError(false, "Error de fechas");
            } else if (desde.isAfter(hasta)) {
                return new ObjResponseError(false, "Error de fechas");
            } else if (estadia > 28) {
                return new ObjResponseError(false, "Error de cantidad de dias");
            } else {
                if (estadia >= 7 && estadia < 30) {
                    descuento = list.getBasePrice() * estadia * (1 - list.getWeeklyDiscount());
                    //Este caso no se va a dar nunca porque se revisa que la estadia sea 28 o menos
                } else if (estadia >= 30) {
                    descuento = list.getBasePrice() * estadia * (1 - list.getMonthlyDiscount());
                }
                total = (list.getBasePrice() * estadia) - descuento + list.getCleaningFee();
                return new ObjResponseCheckout(true, "", estadia, (list.getBasePrice() * estadia), descuento, total);
            }
        } else {
            return new ObjResponseError(false, "Error de casa");
        }
    }

}
