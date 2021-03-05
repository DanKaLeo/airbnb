/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danka.airbnb.models;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "listings")
public class Listings implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="list_id")
    private UUID id;
//    @ManyToOne(targetEntity=Users.class)
//    @JoinColumn(name="id")
    private UUID ownerId;
    private String name;
    private String slug;
    private String description;
    private Integer adults;
    private Integer children;
    private Boolean isPetsAllowed;
    private Double basePrice;
    private Double cleaningFee;
    private String imageUrl;
    private Double weeklyDiscount;
    private Double monthlyDiscount;

    public Listings(UUID ownerId, String name, String slug, String description, Integer adults, Integer children, Boolean isPetsAllowed, Double basePrice, Double cleaningFee, String imageUrl, Double weeklyDiscount, Double monthlyDiscount) {
        this.ownerId = ownerId;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.adults = adults;
        this.children = children;
        this.isPetsAllowed = isPetsAllowed;
        this.basePrice = basePrice;
        this.cleaningFee = cleaningFee;
        this.imageUrl = imageUrl;
        this.weeklyDiscount = weeklyDiscount;
        this.monthlyDiscount = monthlyDiscount;
    }

    public Listings() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Boolean getIsPetsAllowed() {
        return isPetsAllowed;
    }

    public void setIsPetsAllowed(Boolean isPetsAllowed) {
        this.isPetsAllowed = isPetsAllowed;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getCleaningFee() {
        return cleaningFee;
    }

    public void setCleaningFee(Double cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getWeeklyDiscount() {
        return weeklyDiscount;
    }

    public void setWeeklyDiscount(Double weeklyDiscount) {
        this.weeklyDiscount = weeklyDiscount;
    }

    public Double getMonthlyDiscount() {
        return monthlyDiscount;
    }

    public void setMonthlyDiscount(Double monthlyDiscount) {
        this.monthlyDiscount = monthlyDiscount;
    }

    @Override
    public String toString() {
        return "Listings{" + "id=" + id + ", ownerId=" + ownerId + ", name=" + name + ", slug=" + slug + ", description=" + description + ", adults=" + adults + ", children=" + children + ", isPetsAllowed=" + isPetsAllowed + ", basePrice=" + basePrice + ", cleaningFee=" + cleaningFee + ", imageUrl=" + imageUrl + ", weeklyDiscount=" + weeklyDiscount + ", monthlyDiscount=" + monthlyDiscount + '}';
    }

}
