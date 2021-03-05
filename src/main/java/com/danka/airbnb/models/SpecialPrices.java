/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "specialprices")
public class SpecialPrices implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
//    @ManyToOne(targetEntity=Listings.class)
//    @JoinColumn(name="list_id")
    private UUID listing_id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Double price;

    public SpecialPrices() {
    }

    public SpecialPrices(UUID listing_id, Date date, Double price) {
        this.listing_id = listing_id;
        this.date = date;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getListing_id() {
        return listing_id;
    }

    public void setListing_id(UUID listing_id) {
        this.listing_id = listing_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SpecialPrices{" + "id=" + id + ", listing_id=" + listing_id + ", date=" + date + ", price=" + price + '}';
    }

}
