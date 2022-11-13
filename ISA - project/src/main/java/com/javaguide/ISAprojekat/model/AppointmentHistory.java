package com.javaguide.ISAprojekat.model;

import javax.persistence.*;

@Entity
public class AppointmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment appointment;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @Column
    private boolean showedUp;
    @Column
    private boolean passSurvey;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private Report report;
    //odkom kad uradimo pregled
    //private MedicalExam medicalExam;


    public AppointmentHistory(Appointment appointment, Client client, boolean showedUp, boolean passSurvey) {
        this.appointment = appointment;
        this.client = client;
        this.showedUp = showedUp;
        this.passSurvey = passSurvey;
    }

    public AppointmentHistory() {

    }
}
