package com.javaguide.ISAprojekat.model;

import java.time.LocalTime;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.*;
@Entity
public class BloodTransfusionCenter {
      @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column
    private String description;
    @Column
    private double averageGrade;
    @OneToOne(cascade = CascadeType.ALL)
    private WorkHours workHours;
    // ne ide u bazu
    private ArrayList<Appointment> freeAppointment;
    //ne ide u bazu
    private ArrayList<MedicalStaff> medicalStaff;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BloodBank> bloodBanks;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MedicalStaff> centerAdministrators; // ovde glavni

  public BloodTransfusionCenter() {}

}
