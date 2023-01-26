package com.javaguide.ISAprojekat.model;

import com.javaguide.ISAprojekat.dto.AppointmentDTO;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Appointment {
    @Id
    @SequenceGenerator(name = "my_seq_gen_app", sequenceName = "my_seq_gen_app", initialValue = 6, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_gen_app")
    private Long id;

    @ManyToMany(mappedBy = "appointments")
    private Set<MedicalStaff> medicalStaff;
    @Column
    private LocalDateTime startTime;
    @Column
    private LocalDateTime endTime;
    @Column
    private boolean taken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bloodTransfusionCenter_id")
    private BloodTransfusionCenter bloodTransfusionCenter;

    public Appointment() {
    }
    public Appointment(AppointmentDTO appointmentDTO) {
        this.setStartTime(appointmentDTO.getStartDate());
        this.setEndTime(appointmentDTO.getEndDate());
        this.taken=false;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setBloodTransfusionCenter(BloodTransfusionCenter bloodTransfusionCenter) {
        this.bloodTransfusionCenter = bloodTransfusionCenter;
    }

    public BloodTransfusionCenter getBloodTransfusionCenter() {
        return bloodTransfusionCenter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<MedicalStaff> getMedicalStaff() {
        return medicalStaff;
    }

    public void setMedicalStaff(Set<MedicalStaff> medicalStaff) {
        this.medicalStaff = medicalStaff;
    }

}
