package com.javaguide.ISAprojekat.model;

import java.util.ArrayList;

public class Report {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BloodType bloodType;
    private double quantity;
    private ArrayList<Equipment> usedEquipment;
}
