package com.javaguide.ISAprojekat.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class MedicalStaff extends User{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="blood_transfusion_center_id",referencedColumnName = "id")
    @JsonIgnore
    private BloodTransfusionCenter bloodTransfusionCenter;
    @ManyToMany( cascade = {CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(name = "taking_blood", joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"))
    private Set<Appointment> appointments;

    public MedicalStaff() {
    }

    public MedicalStaff(int id,String password, String email, String firstName, String lastName, String phoneNumber,  String jmbg, String gender) {
        super(id,password, email, firstName, lastName, phoneNumber, jmbg, gender);

    }

    public BloodTransfusionCenter getBloodTransfusionCenter() {
        return bloodTransfusionCenter;
    }

    public void setBloodTransfusionCenter(BloodTransfusionCenter bloodTransfusionCenter) {
        this.bloodTransfusionCenter = bloodTransfusionCenter;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }


}
