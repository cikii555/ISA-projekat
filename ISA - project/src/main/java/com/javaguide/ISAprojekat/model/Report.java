package com.javaguide.ISAprojekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BloodType bloodType;
    private double quantity;
    //odkomentarisati kad se bude radila cela tabela
    //private ArrayList<Equipment> usedEquipment;
}
