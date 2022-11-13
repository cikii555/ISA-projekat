package com.javaguide.ISAprojekat.model;

import javax.persistence.*;

@Entity
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LoyaltyType loyaltyType;
    @Column
    private double points;

    public LoyaltyProgram() {}
    public LoyaltyProgram(Long id, LoyaltyType loyaltyType, double points) {
        this.id = id;
        this.loyaltyType = loyaltyType;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LoyaltyType getLoyaltyType() {
        return loyaltyType;
    }

    public void setLoyaltyType(LoyaltyType loyaltyType) {
        this.loyaltyType = loyaltyType;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
