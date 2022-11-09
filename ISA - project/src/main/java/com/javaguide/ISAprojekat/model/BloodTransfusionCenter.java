package com.javaguide.ISAprojekat.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class BloodTransfusionCenter {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Address address;
    private String description;
    private double averageGrade;
    private WorkHours workHours;
    // ne ide u bazu
    private ArrayList<Appointment> freeAppointment;
    //ne ide u bazu
    private ArrayList<MedicalStaff> medicalStaff;
    private BloodBank bloodBank;
    private MedicalStaff centerAdministrator; // ovde glavni


}
