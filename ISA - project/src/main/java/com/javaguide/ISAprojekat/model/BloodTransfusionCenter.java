package com.javaguide.ISAprojekat.model;

import java.time.LocalTime;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.*;


@Entity
public class BloodTransfusionCenter {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column
    private String description;
    @Column
    private double averageGrade;
    @ManyToOne(cascade = CascadeType.ALL)
    private WorkHours workHours;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> freeAppointment;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MedicalStaff> medicalStaff;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BloodBank> bloodBanks;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Equipment> equipment;
    @OneToMany(mappedBy = "bloodTransfusionCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MedicalStaff> centerAdministrators; // ovde glavni

  public BloodTransfusionCenter() {}

 public BloodTransfusionCenter(String name, Address address, String description, double averageGrade) {
  this.name = name;
  this.address = address;
  this.description = description;
  this.averageGrade = averageGrade;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Address getAddress() {
  return address;
 }

 public void setAddress(Address address) {
  this.address = address;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public double getAverageGrade() {
  return averageGrade;
 }

 public void setAverageGrade(double averageGrade) {
  this.averageGrade = averageGrade;
 }

 public WorkHours getWorkHours() {
  return workHours;
 }

 public void setWorkHours(WorkHours workHours) {
  this.workHours = workHours;
 }


    public Set<Appointment> getFreeAppointment() {
        return freeAppointment;
    }

    public void setFreeAppointment(Set<Appointment> freeAppointment) {
        this.freeAppointment = freeAppointment;
    }

    public Set<MedicalStaff> getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(Set<MedicalStaff> medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

    public Set<BloodBank> getBloodBanks() {
        return bloodBanks;
    }

    public void setBloodBanks(Set<BloodBank> bloodBanks) {
        this.bloodBanks = bloodBanks;
    }

    public Set<MedicalStaff> getCenterAdministrators() {
        return centerAdministrators;
    }

    public void setCenterAdministrators(Set<MedicalStaff> centerAdministrators) {
        this.centerAdministrators = centerAdministrators;
    }

//=======
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public double getAverageGrade() {
//        return averageGrade;
//    }
//
//    public WorkHours getWorkHours() {
//        return workHours;
//    }
//
//    public Set<Appointment> getFreeAppointment() {
//        return freeAppointment;
//    }
//
//    public Set<MedicalStaff> getMedicalStaff() {
//        return medicalStaff;
//    }
//
//    public Set<BloodBank> getBloodBanks() {
//        return bloodBanks;
//    }
//
//    public Set<MedicalStaff> getCenterAdministrators() {
//        return centerAdministrators;
//    }
//>>>>>>> HomePageClient

}


