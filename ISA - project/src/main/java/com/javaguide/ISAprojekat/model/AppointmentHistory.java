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
    @Column
    private boolean isCanceled;

    @Column
    private AppointmentStatus appointmentStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private Report report;
    //odkom kad uradimo pregled
    //private MedicalExam medicalExam;


    public AppointmentHistory(Appointment appointment, Client client, boolean showedUp, boolean passSurvey, boolean isCanceled) {
        this.appointment = appointment;
        this.client = client;
        this.showedUp = showedUp;
        this.passSurvey = passSurvey;
        this.isCanceled = isCanceled;
    }

    public AppointmentHistory() {

    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isShowedUp() {
        return showedUp;
    }

    public void setShowedUp(boolean showedUp) {
        this.showedUp = showedUp;
    }

    public boolean isPassSurvey() {
        return passSurvey;
    }

    public void setPassSurvey(boolean passSurvey) {
        this.passSurvey = passSurvey;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
