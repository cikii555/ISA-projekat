package com.javaguide.ISAprojekat.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;
@Entity
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private BloodType bloodType;
    @Column
    private double quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloodTransfusionCenter_id", referencedColumnName = "id")
    @JsonIgnore
    private BloodTransfusionCenter bloodTransfusionCenter;

    public BloodBank() {}

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

    public BloodTransfusionCenter getBloodTransfusionCenter() {
        return bloodTransfusionCenter;
    }

    public void setBloodTransfusionCenter(BloodTransfusionCenter bloodTransfusionCenter) {
        this.bloodTransfusionCenter = bloodTransfusionCenter;
    }
}
