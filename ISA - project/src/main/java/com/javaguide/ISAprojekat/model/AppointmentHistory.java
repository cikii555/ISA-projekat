package com.javaguide.ISAprojekat.model;

public class AppointmentHistory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Appointment appointment;
    private Client client;
    private boolean showedUp;
    private boolean passSurvey;
    private Report report;
    private MedicalExam medicalExam;

}
