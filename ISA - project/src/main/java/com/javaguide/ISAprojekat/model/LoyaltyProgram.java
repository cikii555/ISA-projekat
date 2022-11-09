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
}
