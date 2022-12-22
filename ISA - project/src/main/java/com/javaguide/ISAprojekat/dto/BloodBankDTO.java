package com.javaguide.ISAprojekat.dto;

import com.javaguide.ISAprojekat.model.BloodType;

public class BloodBankDTO {

    private Long id;
    private BloodType bloodType;
    private double quantity;
    private Integer idCenter;

    public BloodBankDTO(Long id, BloodType bloodType, double quantity, Integer idCenter) {
        this.id = id;
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.idCenter = idCenter;
    }

    public BloodBankDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Integer getIdCenter() {
        return idCenter;
    }

    public void setIdCenter(Integer idCenter) {
        this.idCenter = idCenter;
    }
}
