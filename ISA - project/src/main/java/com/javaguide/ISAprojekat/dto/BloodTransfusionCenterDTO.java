package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.Address;
import com.javaguide.ISAprojekat.model.BloodTransfusionCenter;

public class BloodTransfusionCenterDTO {
    private String name;
    private String description;
    private Double rating;
    private Address address;
    private Integer id;

    public BloodTransfusionCenterDTO(String name, String description, Double rating, Address address,Integer id) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.address = address;
        this.id = id;
    }

    public BloodTransfusionCenterDTO(BloodTransfusionCenter center) {
        this(center.getName(),center.getDescription(),center.getAverageGrade(),center.getAddress(),center.getId());
    }

    public BloodTransfusionCenterDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
