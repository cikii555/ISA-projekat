package com.javaguide.ISAprojekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private BloodType bloodType;
    @Column
    private double quantity;
    //odkomentarisati kad se bude radila cela tabela
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name = "equipment_report", joinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"))
    private Set<Equipment> usedEquipment;

    public Report(Long id, BloodType bloodType, double quantity, Set<Equipment> usedEquipment) {
        this.id = id;
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.usedEquipment = usedEquipment;
    }
    public Report (Long id, BloodType bloodType, double qunatity){
        this.id = id;
        this.bloodType = bloodType;
        this.quantity = quantity;
    }
    public Report() {
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

    public Set<Equipment> getUsedEquipment() {
        return usedEquipment;
    }

    public void setUsedEquipment(Set<Equipment> usedEquipment) {
        this.usedEquipment = usedEquipment;
    }
}
