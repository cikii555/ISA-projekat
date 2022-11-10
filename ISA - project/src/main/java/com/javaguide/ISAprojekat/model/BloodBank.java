package com.javaguide.ISAprojekat.model;
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
    @JoinColumn(name = "bloodTransfusionCenter_id")
    private BloodTransfusionCenter bloodTransfusionCenter;

    public BloodBank() {}
}
