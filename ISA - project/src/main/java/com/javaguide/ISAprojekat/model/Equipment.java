package com.javaguide.ISAprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private double quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="blood_transfusion_center_id",referencedColumnName = "id")
    @JsonIgnore
    private BloodTransfusionCenter bloodTransfusionCenter;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "equipment_report", joinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"))
    private Set<Report> report;

    public Equipment(Long id, String name, double quantity, BloodTransfusionCenter bloodTransfusionCenter) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.bloodTransfusionCenter = bloodTransfusionCenter;
    }

    public Equipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Report> getReport() {
        return report;
    }

    public void setReport(Set<Report> report) {
        this.report = report;
    }
}
