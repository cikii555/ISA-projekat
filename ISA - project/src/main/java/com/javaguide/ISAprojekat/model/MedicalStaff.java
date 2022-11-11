package com.javaguide.ISAprojekat.model;
import javax.persistence.*;
import java.util.*;
@Entity
public class MedicalStaff extends User{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bloodTransfusionCenter_id")
    private BloodTransfusionCenter bloodTransfusionCenter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medicalStaff_id")
    private Appointment appointment;
    public MedicalStaff() {
    }
}
